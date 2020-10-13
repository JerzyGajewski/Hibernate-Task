package pl.coderslab.fixture;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.service.AuthorService;
import pl.coderslab.service.BookService;

import java.util.Random;


@Component
public class AuthorFixture {
    private AuthorService authorService;
    private Faker faker;

    @Autowired

    public AuthorFixture(AuthorService authorService) {
        this.authorService = authorService;
        this.faker = new Faker();
    }
    public void createDataInDb(){
        Random random = new Random();

        for (int i = 0; i < 15; i++) {


            Author author = new Author();
            author.setFirstName(this.faker.name().firstName());
            author.setLastName(this.faker.name().lastName());
            this.authorService.save(author);

        }
    }
}

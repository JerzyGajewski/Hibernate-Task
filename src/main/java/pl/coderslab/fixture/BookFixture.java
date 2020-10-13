package pl.coderslab.fixture;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
import pl.coderslab.service.AuthorService;
import pl.coderslab.service.BookService;
import pl.coderslab.service.PublisherService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class BookFixture {
    private AuthorService authorService;
    private PublisherService publisherService;
    private BookService bookService;
    private Faker faker;

    @Autowired
    public BookFixture(BookService bookService, PublisherService publisherService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.publisherService = publisherService;
        this.faker = new Faker();
    }

    public void createDataInDb() {
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            long publisherId = (long) (random.nextInt(3) + 1);
            Publisher publisher = publisherService.findOneById(publisherId);
            long authorId = (long)(random.nextInt(3)+1);
            Author author = authorService.findOneById(authorId);
            List<Author> authorList = new ArrayList<>();
            authorList.add(author);
            Book book = new Book();
            book.setTitle(this.faker.book().title());
            book.setRating(random.nextInt(9) + 1);
            book.setDescription(this.faker.superhero().descriptor());
            book.setPublishers(publisher);
            book.setAuthors(authorList);
            this.bookService.save(book);

        }
    }

}

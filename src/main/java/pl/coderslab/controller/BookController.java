package pl.coderslab.controller;

import com.github.javafaker.Faker;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
import pl.coderslab.service.AuthorService;
import pl.coderslab.service.BookService;
import pl.coderslab.service.PublisherService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/book")
public class BookController {
    private AuthorService authorService;
    private BookService bookService;
    private PublisherService publisherService;
    private Faker faker;

    @Autowired
    public BookController(BookService bookService, PublisherService publisherService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.publisherService = publisherService;
        this.faker = new Faker();
    }

    @GetMapping("/add")
    @ResponseBody
    public String saveBook() {

        Publisher publisher = publisherService.findOneById(1L);


        Book book = new Book();
        book.setTitle(this.faker.superhero().name());
        Random random = new Random();
        book.setRating(random.nextInt(9)+1);
        book.setDescription(this.faker.superhero().descriptor());
        book.setPublishers(publisher);
        this.bookService.save(book);

        return "Book saved at id: " + book.getId();
    }

    @PutMapping("/find/{id}")
    @ResponseBody
    public Book findById(@PathVariable Long id) {
        Book book = this.bookService.findOneById(id);
        return book;
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable Long id){
        Book book = this.bookService.findOneById(id);
        this.bookService.delete(book);

        return "Deleted book ";
    }
    @GetMapping()
    @Transactional
    public String allBooks(Model model){
        List<Book> bookList = this.bookService.findAllWithPublisher();
        bookList.forEach( book -> Hibernate.initialize(book.getAuthors() ) );
        model.addAttribute("books", bookList);
        return "book/list";
    }

    @GetMapping("/rating/{rate}")
    public String getByRating(@PathVariable int rate, Model model){
        List<Book> books = this.bookService.findAllByRating(rate);
        model.addAttribute("books", books);
        return "book/list";

    }

    @GetMapping("/find/{name}")
    public String getByPublisher(@PathVariable String name, Model model){
        Publisher publisher = this.publisherService.findOneByName(name);
        List<Book> books = this.bookService.findWithPublisher(publisher);
        model.addAttribute("books", books);
        return "book/list";
    }

    @GetMapping("/find/{firstName}")
    public String getByAuthor(@PathVariable String firstName, Model model){
        Author author = this.authorService.findByName(firstName);
        List<Book> books = this.bookService.findWithAuthors(author);
        model.addAttribute("books", books);
        return "book/list";
    }

}

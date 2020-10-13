package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
import pl.coderslab.service.BookService;
import pl.coderslab.service.PublisherService;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    private BookService bookService;
    private PublisherService publisherService;

    @Autowired
    public BookController(BookService bookService, PublisherService publisherService) {
        this.bookService = bookService;
        this.publisherService = publisherService;
    }

    @GetMapping("/add")
    @ResponseBody
    public String saveBook() {

        Publisher publisher = publisherService.findOneById(1L);

        Book book = new Book();
        book.setTitle("Wiedźmin");
        book.setRating(8);
        book.setDescription("some desc");
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
    public String allBooks(Model model){
        List<Book> bookList = this.bookService.findAllWithPublisher();
        model.addAttribute("books", bookList);
        return "book/list";
    }


}

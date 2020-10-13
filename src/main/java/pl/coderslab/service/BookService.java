package pl.coderslab.service;

import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import java.util.List;

public interface BookService {

    public void save(Book book);

    public Book findOneById(Long id);

    public void delete(Book book);

    public List<Book> findAll();

    public List<Book> findAllWithPublisher();

    public List<Book> findAllByRating(int rating);

    public List<Book> findWithPublisher(Publisher publisher);

    public List<Book> findWithAuthors(Author author);
}

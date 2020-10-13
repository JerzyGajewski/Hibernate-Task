package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import java.util.List;

@Service
@Primary
public class BookServiceDb implements BookService {
    private BookDao bookDao;

    @Autowired
    public BookServiceDb(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public void save(Book book) {
        this.bookDao.save(book);
    }

    @Override
    public Book findOneById(Long id) {
        return this.bookDao.fintOneById(id);
    }

    @Override
    public void delete(Book book) {
        this.bookDao.delete(book);
    }

    @Override
    public List<Book> findAll() {
        return this.bookDao.findAll();
    }

    @Override
    public List<Book> findAllWithPublisher() {
        return this.bookDao.findAllWithPublisher();
    }

    @Override
    public List<Book> findAllByRating(int rating) {
        return this.bookDao.findAllByRating(rating);
    }

    @Override
    public List<Book> findWithPublisher(Publisher publisher) {
        return this.bookDao.findWithPublisher(publisher);
    }

    @Override
    public List<Book> findWithAuthors(Author author) {
        return this.bookDao.findWithAuthor(author);
    }
}

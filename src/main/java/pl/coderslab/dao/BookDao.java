package pl.coderslab.dao;


import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDao {

    @PersistenceContext
    private EntityManager em;

    public void save(Book book) {
        if (book.getId() == null) {
            this.em.persist(book);
        } else this.em.merge(book);
    }

    public Book fintOneById(Long id) {
        return this.em.find(Book.class, id);
    }

    public void delete(Book book) {
        this.em.remove(this.em.contains(book) ? book : this.em.merge(book));
    }

    public List<Book> findAll() {
        Query query = this.em.createQuery("Select b from Book b order by b.title asc");
        return (List<Book>) query.getResultList();
    }

    public List<Book> findAllWithPublisher() {
        Query query = this.em.createQuery("select b from Book b JOIN fetch b.publishers ORDER BY b.title asc");
        List<Book> books = query.getResultList();
        return books;
    }

    public List<Book> findWithPublisher(Publisher publisher){
        Query query = this.em.createQuery("select b from Book b where b.publishers = :publisher");
        query.setParameter("publisher", publisher);
        List<Book> books = query.getResultList();
        return books;
    }

    public List<Book> findAllByRating(int rating) {
        Query query = this.em.createQuery("select b from Book b where b.rating = :rating");
        query.setParameter("rating", rating);
        List<Book> books = query.getResultList();
        return books;
    }

    public List<Book> findWithAuthor(Author author) {
        Query query = this.em.createQuery("select b from Book b join fetch b.authors where b.authors = :author");
        query.setParameter("author", author);
        List<Book> books = query.getResultList();
        return books;
    }
}

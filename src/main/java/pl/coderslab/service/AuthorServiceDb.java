package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.entity.Author;

import javax.management.Query;
import java.util.List;


@Service
@Primary
public class AuthorServiceDb implements AuthorService {
    private AuthorDao authorDao;

    @Autowired
    public AuthorServiceDb(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Override
    public void save(Author author) {
        this.authorDao.save(author);
    }

    @Override
    public Author findOneById(Long id) {
        return this.authorDao.findOneById(id);
    }

    @Override
    public void delete(Author author) {
        this.authorDao.delete(author);
    }

    @Override
    public List<Author> findAll() {
        return this.authorDao.findAll();

    }

    @Override
    public Author findByName(String firstName) {
        return this.authorDao.findByName(firstName);
    }
}

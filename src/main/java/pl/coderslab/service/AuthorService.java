package pl.coderslab.service;

import pl.coderslab.entity.Author;

import java.util.List;

public interface AuthorService {

    public void save(Author author);
    public Author findOneById(Long id);
    public void delete(Author author);
    public List<Author> findAll();
    public Author findByName(String firstName);
}

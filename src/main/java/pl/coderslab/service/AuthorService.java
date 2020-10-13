package pl.coderslab.service;

import pl.coderslab.entity.Author;

public interface AuthorService {

    public void save(Author author);
    public Author findOneById(Long id);
    public void delete(Author author);
}

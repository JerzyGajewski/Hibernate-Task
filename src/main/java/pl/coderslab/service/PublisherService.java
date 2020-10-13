package pl.coderslab.service;

import pl.coderslab.entity.Publisher;

import java.util.List;

public interface PublisherService {

    public void save(Publisher publisher);
    public Publisher findOneById(Long id);
    public void delete(Publisher publisher);
    public List<Publisher> findAll();
    public Publisher findOneByName(String name);
}

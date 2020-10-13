package pl.coderslab.service;

import pl.coderslab.entity.Publisher;

public interface PublisherService {

    public void save(Publisher publisher);
    public Publisher findOneById(Long id);
    public void delete(Publisher publisher);
}

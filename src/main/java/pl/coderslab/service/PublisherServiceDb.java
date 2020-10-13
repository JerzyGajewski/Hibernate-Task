package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Publisher;

import java.util.List;

@Service
@Primary
public class PublisherServiceDb implements PublisherService {

    private PublisherDao publisherDao;

    @Autowired
    public PublisherServiceDb(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }


    @Override
    public void save(Publisher publisher) {
        this.publisherDao.save(publisher);
    }

    @Override
    public Publisher findOneById(Long id) {
        return this.publisherDao.findOneById(id);
    }

    @Override
    public void delete(Publisher publisher) {
        this.publisherDao.delete(publisher);
    }

    @Override
    public List<Publisher> findAll() {
        return this.publisherDao.findAll();
    }

    @Override
    public Publisher findOneByName(String name) {
        return this.publisherDao.findOneByName(name);
    }
}

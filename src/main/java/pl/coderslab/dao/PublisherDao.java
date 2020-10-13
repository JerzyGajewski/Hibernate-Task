package pl.coderslab.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PublisherDao {

    @PersistenceContext
    private EntityManager em;

    public void save(Publisher publisher) {
        if (publisher.getId() == null) {
            this.em.persist(publisher);
        } else this.em.merge(publisher);
    }

    public Publisher findOneById(Long id) {
        return this.em.find(Publisher.class, id);
    }

    public void delete(Publisher publisher) {
        this.em.remove(this.em.contains(publisher) ? publisher : this.em.merge(publisher));
    }

    public List<Publisher> findAll() {
        Query query = this.em.createQuery("select p from Publisher p order by p.name asc ");
        List<Publisher> list = query.getResultList();
        return list;
    }

    public Publisher findOneByName(String name) {
        Query query = this.em.createQuery("select p from Publisher p where p.name = :name");
        query.setParameter("name", name);
        return (Publisher) query.getSingleResult();
    }
}

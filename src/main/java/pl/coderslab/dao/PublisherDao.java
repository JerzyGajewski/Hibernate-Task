package pl.coderslab.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PublisherDao {

    @PersistenceContext
    private EntityManager em;

    public void save(Publisher publisher){
        if(publisher.getId() == null){
            this.em.persist(publisher);
        }else this.em.merge(publisher);
    }
    public Publisher findOneById(Long id){
        return this.em.find(Publisher.class, id);
    }

    public void delete(Publisher publisher){
        this.em.remove(this.em.contains(publisher) ? publisher : this.em.merge(publisher));
    }

}

package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {
    // entity menager z kontekstem zawartym przy tworzeniu aplikacji
    @PersistenceContext
    private EntityManager em;

    public void save(Author author){
        if(author.getId() == null){
            this.em.persist(author);
        } else this.em.merge(author);
    }

    public Author findOneById(Long id){
        return this.em.find(Author.class, id);
    }
    public void delete(Author author){
        this.em.remove(this.em.contains(author) ? author : this.em.merge(author));
    }

    public List<Author> findAll() {
        Query query = this.em.createQuery("select a from Author a order by a.firstName asc");
        List<Author> authors = query.getResultList();
        return authors;
    }

    public Author findByName(String firstName) {
        Query query = this.em.createQuery("select a from Author a where a.firstName= :firstName");
        query.setParameter("firstName", firstName);
        return (Author) query.getSingleResult();
    }
}

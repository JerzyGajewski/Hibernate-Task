package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

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
}

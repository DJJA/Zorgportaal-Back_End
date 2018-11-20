package dao;

import domain.HealthRating;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collection;

public class HealthRatingJPAImpl extends GenericDAO implements HealthRatingDAO {

    public HealthRatingJPAImpl(EntityManager em) {
        super(em);
    }

    public Collection<HealthRating> getAll() {
        return null;
    }

    public HealthRating getById(Long id) {
        return null;
    }

    public HealthRating add(HealthRating value) {
        em.persist(value);
        return null;
    }

    public HealthRating update(HealthRating value) {
        return em.merge(value);
    }

    public void delete(HealthRating healthRating) {
        em.remove(healthRating);
    }

    public Iterable<HealthRating> getClientsHealthRatings(Long clientId) {
        Iterable<HealthRating> healthRatings = null;

//        Query q = em.createQuery("select h from HealthRating as h where")

        return healthRatings;
    }
}

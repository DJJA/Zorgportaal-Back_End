package dao;

import domain.HealthRating;

import javax.persistence.EntityManager;
import java.util.Collection;

public class HealthRatingJPAImpl implements HealthRatingDAO {
    private EntityManager em;

    public HealthRatingJPAImpl(EntityManager em) {
        this.em = em;
    }

    public Collection<HealthRating> getAll() {
        return null;
    }

    public HealthRating add(HealthRating value) {
        em.persist(value);
        return null;
    }

    public HealthRating update(HealthRating value) {
        return null;
    }
}

package service;

import dao.HealthRatingDAO;
import dao.HealthRatingJPAImpl;
import domain.HealthRating;
import factory.HibernateFactory;

import javax.persistence.EntityManager;

public class HealthRatingManager {

    public void addHealthRating(HealthRating healthRating) {
        EntityManager em = HibernateFactory.getEntityManager();
        HealthRatingDAO dao = new HealthRatingJPAImpl(em);

        em.getTransaction().begin();

        dao.add(healthRating);

        em.getTransaction().commit();
        em.close();
    }

    public Iterable<HealthRating> getClientsHealthratings(Long clientId) {
        return null;
    }

    public void removeHealthRating(Long healthRatingId) {
        // this is random text 5
    }
}

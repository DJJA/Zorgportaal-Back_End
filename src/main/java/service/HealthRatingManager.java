package service;

import dao.HealthRatingDAO;
import dao.HealthRatingJPAImpl;
import domain.HealthRating;
import factory.DAOFactory;
import factory.HibernateFactory;

import javax.persistence.EntityManager;

public class HealthRatingManager {

    public void addHealthRating(HealthRating healthRating) {
        HealthRatingDAO healthRatingDAO = DAOFactory.getHealthRatingDAO();
        EntityManager em = healthRatingDAO.getEntityMangaer();

        em.getTransaction().begin();

        healthRatingDAO.add(healthRating);

        em.getTransaction().commit();
        em.close();
    }

    public void updateHealthRating(HealthRating healthRating) {
        HealthRatingDAO healthRatingDAO = DAOFactory.getHealthRatingDAO();
        EntityManager em = healthRatingDAO.getEntityMangaer();

        em.getTransaction().begin();

        healthRatingDAO.update(healthRating);

        em.getTransaction().commit();
        em.close();
    }

    public Iterable<HealthRating> getClientsHealthratings(Long clientId) {
        return DAOFactory.getHealthRatingDAO().getClientsHealthRatings(clientId);
    }

    public void removeHealthRating(Long healthRatingId) {
        HealthRatingDAO healthRatingDAO = DAOFactory.getHealthRatingDAO();
        EntityManager em = healthRatingDAO.getEntityMangaer();

        em.getTransaction().begin();

        healthRatingDAO.delete(new HealthRating(healthRatingId));

        em.getTransaction().commit();
        em.close();
    }
}

package factory;

import dao.HealthRatingDAO;
import dao.HealthRatingJPAImpl;
import dao.user.ClientDAO;
import dao.user.ClientDAOImpl;
import dao.user.MentorDAO;
import dao.user.MentorDAOJPAImpl;

public class DAOFactory {

    public static ClientDAO getClientDAO() {
        return new ClientDAOImpl(HibernateFactory.getEntityManager());
    }

    public static MentorDAO getMentorDAO() {
        return new MentorDAOJPAImpl(HibernateFactory.getEntityManager());
    }

    public static HealthRatingDAO getHealthRatingDAO() {
        return new HealthRatingJPAImpl(HibernateFactory.getEntityManager());
    }
}

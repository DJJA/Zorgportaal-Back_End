package factory;

import dao.HealthRatingDAO;
import dao.HealthRatingJPAImpl;
import dao.user.*;

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

    public static AccountDAO getAccountDAO() {
        return new AccountDAOJPAImpl(HibernateFactory.getEntityManager());
    }
}

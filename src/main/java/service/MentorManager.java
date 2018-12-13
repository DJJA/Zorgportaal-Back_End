package service;

import dao.user.MentorDAO;
import domain.Client;
import domain.Mentor;
import factory.DAOFactory;

import javax.persistence.EntityManager;

public class MentorManager {

    public void addMentor(Mentor mentor) {
        MentorDAO mentorDAO = DAOFactory.getMentorDAO();
        EntityManager em = mentorDAO.getEntityMangaer();    // TODO: Waarom deze wel dan? Maar de update en add niet....

        em.getTransaction().begin();

        if(mentor.getAccount() != null)
            mentor.setAccount(em.merge(mentor.getAccount()));

        mentorDAO.add(mentor);

        em.getTransaction().commit();
        em.close();
    }

    public void updateMentor(Mentor mentor) {
        MentorDAO mentorDAO = DAOFactory.getMentorDAO();
        EntityManager em = mentorDAO.getEntityMangaer();

        em.getTransaction().begin();

        if(mentor.getAccount() != null)
            mentor.setAccount(em.merge(mentor.getAccount()));

        mentorDAO.update(mentor);

        em.getTransaction().commit();   // TODO: Error handling
        em.close();
    }

    public Mentor getMentorById(Long mentorId) {
        return DAOFactory.getMentorDAO().getById(mentorId);
    }

    public Iterable<Mentor> getAllMentors() {
        return DAOFactory.getMentorDAO().getAll();
    }

    public void addClientToMentor(Long mentorId, Long clientId) {
        MentorDAO mentorDAO = DAOFactory.getMentorDAO();
        EntityManager em = mentorDAO.getEntityMangaer();

        em.getTransaction().begin();

        mentorDAO.addClientToMentor(mentorId, clientId);

        em.getTransaction().commit();
        em.close();
    }

    public void removeClientFromMentor(Long mentorId, Long clientId) {
        MentorDAO mentorDAO = DAOFactory.getMentorDAO();
        EntityManager em = mentorDAO.getEntityMangaer();

        em.getTransaction().begin();

        mentorDAO.removeClientFromMentor(mentorId, clientId);

        em.getTransaction().commit();
        em.close();
    }
}

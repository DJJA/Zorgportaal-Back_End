package dao.user;

import dao.DAO;
import dao.GenericDAO;
import domain.Client;

public interface ClientDAO extends DAO<Client> {
    Iterable<Client> getClientsByMentorId(Long mentorId);
}

package dao.user;

import dao.DAO;
import domain.Mentor;

public interface MentorDAO extends DAO<Mentor> {
    void addClientToMentor(Long mentorId, Long clientId);
    void removeClientFromMentor(Long mentorId, Long clientId);
}

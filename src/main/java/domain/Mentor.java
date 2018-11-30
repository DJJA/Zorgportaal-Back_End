package domain;

import authentication.Account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.Date;

@Entity
@PrimaryKeyJoinColumn(name = "UserId")
@Table(name = "Mentor")
public class Mentor extends User {
    @Column(name = "Education")
    private String education;

    public Mentor() {
        super();
        // Needed for Hibernate
    }

    public Mentor(String fuillName, Date birthday, Gender gender, Account account, String education) {
        super(fuillName, birthday, gender, account);
        this.education = education;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;

        Mentor mentor = (Mentor) obj;
        if (!this.education.equals(mentor.education)) return false;

        return super.equals(obj);
    }
}

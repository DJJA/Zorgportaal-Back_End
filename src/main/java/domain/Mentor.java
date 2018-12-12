package domain;

import authentication.Account;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "UserId")
@Table(name = "Mentor")
public class Mentor extends User {
    @Column(name = "Education")
    private String education;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Mentor_Client",
        joinColumns = @JoinColumn(name = "MentorId"),
        inverseJoinColumns = @JoinColumn(name = "ClientId")
    )
    private List<Client> clients = new ArrayList<>();

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

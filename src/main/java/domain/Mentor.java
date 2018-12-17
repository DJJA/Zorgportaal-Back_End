package domain;

import authentication.Account;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.*;

@Entity
@PrimaryKeyJoinColumn(name = "UserId")
@Table(name = "Mentor")
public class Mentor extends User {
    @Column(name = "Education")
    private String education;

//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinTable(name = "Mentor_Client",
//        joinColumns = @JoinColumn(name = "MentorId"),
//        inverseJoinColumns = @JoinColumn(name = "ClientId")
//    )
//    @JsonBackReference
//    @JsonIgnore
//    private Set<Client> clients = new HashSet<>();

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

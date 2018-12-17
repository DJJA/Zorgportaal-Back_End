package domain;

import authentication.Account;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.*;

@Entity
@PrimaryKeyJoinColumn(name = "UserId")
@Table(name = "Client")
public class Client extends User {
    @Column(name = "CarePlan")
    private String carePlan;

//    @ManyToMany(mappedBy = "clients", fetch = FetchType.LAZY)
//    @JsonManagedReference
//    @JsonIgnoreProperties("mentors")
//    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "Mentor_Client",
            joinColumns = @JoinColumn(name = "ClientId"),
            inverseJoinColumns = @JoinColumn(name = "MentorId")
    )
    private Set<Mentor> mentors = new HashSet<>();

    public Client() {
        super();                // TODO: Is this necessary?
        // Needed for Hibernate
    }

    public Client(String fuillName, Date birthday, Gender gender, Account account, String carePlan) {
        super(fuillName, birthday, gender, account);
        this.carePlan = carePlan;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;

        Client client = (Client) obj;
        if (!this.carePlan.equals(client.carePlan)) return false;

        if (!super.equals(obj)) return false;

        // TODO: Check for clients, depending on fetchType

//        return super.equals((User) obj);
        return true;
    }
}

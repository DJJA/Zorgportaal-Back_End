package domain;

import authentication.Account;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "UserId")
@Table(name = "Client")
public class Client extends User {
    @Column(name = "CarePlan")
    private String carePlan;

    @ManyToMany(mappedBy = "clients")
    private List<Mentor> mentors = new ArrayList<>();

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

//        return super.equals((User) obj);
        return true;
    }
}

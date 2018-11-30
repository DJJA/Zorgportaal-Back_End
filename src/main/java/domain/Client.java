package domain;

import authentication.Account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.Date;

@Entity
@PrimaryKeyJoinColumn(name = "UserId")
@Table(name = "Client")
public class Client extends User {
    @Column(name = "CarePlan")
    private String carePlan;

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

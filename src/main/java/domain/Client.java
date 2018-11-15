package domain;

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

    public Client(String name, Date birthday, Gender gender, String carePlan) {
        super(name, birthday, gender);
        this.carePlan = carePlan;
    }
}

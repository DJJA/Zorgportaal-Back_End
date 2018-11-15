package domain;

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

    public Mentor(String name, Date birthday, Gender gender, String education) {
        super(name, birthday, gender);
        this.education = education;
    }
}

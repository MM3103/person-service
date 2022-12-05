package liga.medical.medicalpersonservice.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "person_data")
public class PersonData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "birth_dt", nullable = false)
    private Date birthDt;

    @Column(name = "age")
    private Integer age;

    @Column(name = "sex", nullable = false, length = 1)
    private String sex;

    @OneToOne
    private MedicalCard medicalCard;

    @OneToOne
    private Contact contact;

    @OneToOne
    private PersonData parent;
}

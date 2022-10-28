package liga.medical.medicalpersonservice.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "illness")
public class Illness {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "type_id")
    private Long typeId;

    @Column(name = "heaviness")
    private String heaviness;

    @Column(name = "appearance_dttm", nullable = false)
    private java.sql.Timestamp appearanceDttm;

    @Column(name = "recovery_dt")
    private java.sql.Date recoveryDt;

    @ManyToOne
    private MedicalCard medicalCard;
}

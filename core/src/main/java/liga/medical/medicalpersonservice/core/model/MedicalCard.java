package liga.medical.medicalpersonservice.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.sql.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "medical_card")
public class MedicalCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "client_status")
    private String clientStatus;

    @Column(name = "med_status")
    private String medStatus;

    @Column(name = "registry_dt", nullable = false)
    private Date registryDt;

    @Column(name = "comment")
    private String comment;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "medicalCard", cascade = CascadeType.ALL)
    private Set<Illness> illnesses;

    @OneToOne(mappedBy = "medicalCard", orphanRemoval = true, cascade = CascadeType.ALL)
    private PersonData personData;

}

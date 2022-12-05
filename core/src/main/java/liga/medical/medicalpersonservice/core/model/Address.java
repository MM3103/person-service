package liga.medical.medicalpersonservice.core.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "country_id", nullable = false)
    private Long countryId;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "index")
    private Integer index;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "building", nullable = false, length = 32)
    private String building;

    @Column(name = "flat", length = 32)
    private String flat;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    private Contact contact;
}

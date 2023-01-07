package udemy.studying.petclinic.model.person;

import lombok.Data;
import lombok.NoArgsConstructor;
import udemy.studying.petclinic.model.BaseEntity;

import javax.persistence.*;

/**
 * POJO for using in {@link Person} for extended Entities Vet, Owner and etc.
 */
@NoArgsConstructor
@Data
@Entity
@Table(name = "contact_info")
public class ContactInfo extends BaseEntity {

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telephone;

    public ContactInfo(String address, String city, String telephone) {
        this.address = address;
        this.city = city;
        this.telephone = telephone;
    }
}

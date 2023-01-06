package udemy.studying.petclinic.model.person;

import udemy.studying.petclinic.model.BaseEntity;

import javax.persistence.*;

/**
 * POJO for using in {@link Person} for extended Entities Vet, Owner and etc.
 */
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

    public ContactInfo() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

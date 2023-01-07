package udemy.studying.petclinic.model.person;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import udemy.studying.petclinic.model.BaseEntity;

import javax.persistence.*;

@MappedSuperclass
@Data
@NoArgsConstructor
public class Person extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToOne
    @JoinColumn(name = "id_contact_info")
    private ContactInfo contactInfo;

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }
}

package udemy.studying.petclinic.model.person;

import lombok.Data;
import udemy.studying.petclinic.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
public class Person extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private ContactInfo contactInfo;
}

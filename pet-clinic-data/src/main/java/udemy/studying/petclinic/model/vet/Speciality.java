package udemy.studying.petclinic.model.vet;

import udemy.studying.petclinic.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "speciality")
public class Speciality extends BaseEntity {

    public Speciality(String description) {
        this.description = description;
    }

    public Speciality() {

    }

    @Column(name = "description")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

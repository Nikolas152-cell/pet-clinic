package udemy.studying.petclinic.model.vet;

import lombok.Data;
import lombok.NoArgsConstructor;
import udemy.studying.petclinic.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@NoArgsConstructor
@Data
@Entity
@Table(name = "speciality")
public class Speciality extends BaseEntity {

    public Speciality(String description) {
        this.description = description;
    }

    @Column(name = "description")
    private String description;
}

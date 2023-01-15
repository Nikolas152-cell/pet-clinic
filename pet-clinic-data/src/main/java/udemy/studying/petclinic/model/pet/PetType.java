package udemy.studying.petclinic.model.pet;

import lombok.Data;
import udemy.studying.petclinic.model.NamedEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "types")
public class PetType extends NamedEntity {

    @Override
    public String toString() {
        return getName();
    }
}

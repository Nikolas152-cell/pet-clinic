package udemy.studying.petclinic.model.pet;

import lombok.*;
import udemy.studying.petclinic.model.NamedEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "types")
public class PetType extends NamedEntity {

    @Builder
    public PetType(Long id, String name) {
        this.setId(id);
        this.setName(name);
    }

    public PetType() {

    }

    @Override
    public String toString() {
        return getName();
    }
}

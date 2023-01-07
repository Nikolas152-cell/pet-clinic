package udemy.studying.petclinic.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import udemy.studying.petclinic.model.person.Person;
import udemy.studying.petclinic.model.pet.Pet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "owners")
@Data
@NoArgsConstructor
public class Owner extends Person {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    @Builder
    public Owner(Long id, String lastName) {
        this.setId(id);
        this.setLastName(lastName);
    }
}

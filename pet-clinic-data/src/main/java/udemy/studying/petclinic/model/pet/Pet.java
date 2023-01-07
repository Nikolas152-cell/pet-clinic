package udemy.studying.petclinic.model.pet;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import udemy.studying.petclinic.model.NamedEntity;
import udemy.studying.petclinic.model.Owner;
import udemy.studying.petclinic.model.Visit;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Entity
@Table(name = "pets")
@Data
@EqualsAndHashCode(exclude = {"owner"})
public class Pet extends NamedEntity {

    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();

    public Pet(PetType petType, LocalDate birthDate, Owner owner) {
        this.petType = petType;
        this.birthDate = birthDate;
        this.owner = owner;
    }
}

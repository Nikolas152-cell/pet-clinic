package udemy.studying.petclinic.model.pet;

import udemy.studying.petclinic.model.BaseEntity;
import udemy.studying.petclinic.model.NamedEntity;
import udemy.studying.petclinic.model.Owner;

import java.time.LocalDate;

public class Pet extends NamedEntity {
    private PetType petType;
    private LocalDate birthDate;
    private Owner owner;

    public Pet(PetType petType, LocalDate birthDate, Owner owner) {
        this.petType = petType;
        this.birthDate = birthDate;
        this.owner = owner;
    }
    public Pet () {}

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}

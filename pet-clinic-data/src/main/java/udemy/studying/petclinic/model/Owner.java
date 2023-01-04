package udemy.studying.petclinic.model;

import udemy.studying.petclinic.model.pet.Pet;

import java.util.Set;

public class Owner extends Person{

    private Set<Pet> pets;

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}

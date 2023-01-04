package udemy.studying.petclinic.model;

import udemy.studying.petclinic.model.person.Person;
import udemy.studying.petclinic.model.pet.Pet;

import java.util.HashSet;
import java.util.Set;

public class Owner extends Person {

    private Set<Pet> pets = new HashSet<>();

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}

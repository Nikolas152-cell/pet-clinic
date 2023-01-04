package udemy.studying.petclinic.model.vet;

import udemy.studying.petclinic.model.person.Person;

import java.util.Set;

public class Vet extends Person {

    private Set<Speciality> specialities;

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}

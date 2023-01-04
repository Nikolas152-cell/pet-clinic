package udemy.studying.petclinic.model.pet;

import udemy.studying.petclinic.model.BaseEntity;

public class PetType extends BaseEntity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

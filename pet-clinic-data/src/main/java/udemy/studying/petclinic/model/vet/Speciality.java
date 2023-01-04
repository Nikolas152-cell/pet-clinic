package udemy.studying.petclinic.model.vet;

import udemy.studying.petclinic.model.BaseEntity;

public class Speciality extends BaseEntity {
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

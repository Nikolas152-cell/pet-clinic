package udemy.studying.petclinic.model;

import lombok.Data;
import udemy.studying.petclinic.model.pet.Pet;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;
}

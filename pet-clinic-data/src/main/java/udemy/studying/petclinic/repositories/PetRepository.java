package udemy.studying.petclinic.repositories;


import org.springframework.data.repository.CrudRepository;
import udemy.studying.petclinic.model.pet.Pet;

/**
 * Created by jt on 8/5/18.
 */
public interface PetRepository extends CrudRepository<Pet, Long> {
}

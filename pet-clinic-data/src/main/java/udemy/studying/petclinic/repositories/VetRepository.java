package udemy.studying.petclinic.repositories;


import org.springframework.data.repository.CrudRepository;
import udemy.studying.petclinic.model.vet.Vet;

/**
 * Created by jt on 8/5/18.
 */
public interface VetRepository extends CrudRepository<Vet, Long> {
}

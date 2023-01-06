package udemy.studying.petclinic.repositories;


import org.springframework.data.repository.CrudRepository;
import udemy.studying.petclinic.model.Visit;

/**
 * Created by jt on 8/5/18.
 */
public interface VisitRepository extends CrudRepository<Visit, Long> {
}

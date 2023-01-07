package udemy.studying.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import udemy.studying.petclinic.model.person.ContactInfo;

public interface ContactInfoRepository extends CrudRepository<ContactInfo, Long> {
}

package udemy.studying.petclinic.services;

import udemy.studying.petclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}

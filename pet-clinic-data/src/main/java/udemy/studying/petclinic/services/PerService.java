package udemy.studying.petclinic.services;

import udemy.studying.petclinic.model.Pet;

import java.util.Set;

public interface PerService {
    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}

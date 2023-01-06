package udemy.studying.petclinic.services.springdatajpa;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import udemy.studying.petclinic.model.pet.PetType;
import udemy.studying.petclinic.repositories.PetTypeRepository;
import udemy.studying.petclinic.services.PetTypeService;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jt on 8/5/18.
 */
@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeSDJpaService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findById(Long aLong) {
        return petTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petTypeRepository.deleteById(aLong);
    }
}

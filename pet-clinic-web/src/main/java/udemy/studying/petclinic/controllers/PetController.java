package udemy.studying.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import udemy.studying.petclinic.model.Owner;
import udemy.studying.petclinic.model.pet.Pet;
import udemy.studying.petclinic.model.pet.PetType;
import udemy.studying.petclinic.repositories.OwnerRepository;
import udemy.studying.petclinic.services.OwnerService;
import udemy.studying.petclinic.services.PetService;
import udemy.studying.petclinic.services.PetTypeService;

import java.util.Collection;

@Controller
@RequestMapping("owners/{ownerId}")
public class PetController {

    private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";

    private final OwnerService ownerService;
    private final PetService petService;
    private final PetTypeService petTypeService;

    public PetController(OwnerRepository owners, OwnerService ownerService, PetService petService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @ModelAttribute("types")
    public Collection<PetType> populatePetTypes() {
        return petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable("ownerId") Long ownerId) {
        Owner owner = ownerService.findById(ownerId);
        if (owner == null) {
            throw new RuntimeException("Owner with id " + ownerId + " was not found");
        }
        return owner;
    }

    @ModelAttribute("pet")
    public Pet findPet(@PathVariable("ownerId") Long ownerId,
                       @PathVariable(name = "petId", required = false) Long petId) {
        Pet pet;
        if (petId == null) {
            pet = new Pet();
        } else {
            pet = ownerService.findById(ownerId).getPet(petId);
        }
        return pet;
    }

    @InitBinder("owner")
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

}

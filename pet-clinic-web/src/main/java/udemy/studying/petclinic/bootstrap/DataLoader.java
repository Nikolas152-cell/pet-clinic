package udemy.studying.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import udemy.studying.petclinic.model.Owner;
import udemy.studying.petclinic.model.person.ContactInfo;
import udemy.studying.petclinic.model.pet.Pet;
import udemy.studying.petclinic.model.pet.PetType;
import udemy.studying.petclinic.model.vet.Vet;
import udemy.studying.petclinic.services.OwnerService;
import udemy.studying.petclinic.services.PetTypeService;
import udemy.studying.petclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType cat = new PetType();
        cat.setName("Cat Vasya");
        PetType savedCatPetType = petTypeService.save(cat);

        PetType dog = new PetType();
        cat.setName("Dog Vasya");
        PetType savedDogPetType = petTypeService.save(dog);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setContactInfo(new ContactInfo("Naukova 52", "Kharkiv", "0551175918"));
        ownerService.save(owner1);

        Pet kolyasPet = new Pet(savedCatPetType, LocalDate.now(), owner1);
        kolyasPet.setName("Vasya");
        owner1.getPets().add(kolyasPet);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setContactInfo(new ContactInfo("Kyivska 1", "Kyiv", "0665191018"));

        Pet kolyasDog = new Pet(savedDogPetType, LocalDate.now(), owner2);
        kolyasDog.setName("My Dog");

        owner2.getPets().add(kolyasDog);
        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}

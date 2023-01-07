package udemy.studying.petclinic.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import udemy.studying.petclinic.model.Owner;
import udemy.studying.petclinic.model.person.ContactInfo;
import udemy.studying.petclinic.model.pet.Pet;
import udemy.studying.petclinic.model.pet.PetType;
import udemy.studying.petclinic.model.vet.Speciality;
import udemy.studying.petclinic.model.vet.Vet;
import udemy.studying.petclinic.repositories.ContactInfoRepository;
import udemy.studying.petclinic.services.OwnerService;
import udemy.studying.petclinic.services.PetTypeService;
import udemy.studying.petclinic.services.SpecialityService;
import udemy.studying.petclinic.services.VetService;

import java.time.LocalDate;

@Component
@Slf4j
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final ContactInfoRepository contactInfoRepository;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, ContactInfoRepository contactInfoRepository) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.contactInfoRepository = contactInfoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        log.info("Loading data in bootstrap!");

        PetType cat = new PetType();
        cat.setName("Cat Vasya");
        PetType savedCatPetType = petTypeService.save(cat);

        PetType dog = new PetType();
        cat.setName("Dog Vasya");
        PetType savedDogPetType = petTypeService.save(dog);

        Speciality radiology = new Speciality("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);
        Speciality softwareEngineer = new Speciality("SoftwareEngineer");
        Speciality savedSoftwareEngineer = specialityService.save(softwareEngineer);
        Speciality teacher = new Speciality("Teacher");
        Speciality savedTeacher = specialityService.save(teacher);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        ContactInfo ciOwner1 = new ContactInfo("Naukova 52", "Kharkiv", "0551175918");
        owner1.setContactInfo(ciOwner1);
        contactInfoRepository.save(ciOwner1);
        ownerService.save(owner1);

        Pet kolyasPet = new Pet(savedCatPetType, LocalDate.now(), owner1);
        kolyasPet.setName("Vasya");
        owner1.getPets().add(kolyasPet);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        ContactInfo ciOwner2 = new ContactInfo("Kyivska 1", "Kyiv", "0665191018");
        owner2.setContactInfo(ciOwner2);
        contactInfoRepository.save(ciOwner2);


        Pet kolyasDog = new Pet(savedDogPetType, LocalDate.now(), owner2);
        kolyasDog.setName("My Dog");

        owner2.getPets().add(kolyasDog);
        ownerService.save(owner2);

        log.info("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(savedSoftwareEngineer);

        vetService.save(vet2);

        log.debug(vet1.equals(vet2) + " - Vet1 equals Vet2");
        vet1.equals(vet2);

        log.info("Loaded Vets....");
    }
}

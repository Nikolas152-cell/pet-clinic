package udemy.studying.petclinic.services.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import udemy.studying.petclinic.model.Owner;
import udemy.studying.petclinic.repositories.ContactInfoRepository;
import udemy.studying.petclinic.repositories.OwnerRepository;
import udemy.studying.petclinic.repositories.PetRepository;
import udemy.studying.petclinic.repositories.PetTypeRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    private OwnerRepository ownerRepository;
    @Mock
    private PetRepository petRepository;
    @Mock
    private PetTypeRepository petTypeRepository;
    @Mock
    private ContactInfoRepository contactInfoRepository;

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    final String lastName = "Pupkin";

    Owner owner;

    @BeforeEach
    void setUp() {
        owner = Owner.builder().lastName(lastName).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(lastName)).thenReturn(owner);

        assertNotNull(ownerSDJpaService.findByLastName(lastName));
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        owners.add(Owner.builder().id(2L).build());
        owners.add(Owner.builder().id(3L).build());

        when(ownerRepository.findAll()).thenReturn(owners);

        assertEquals(2, ownerSDJpaService.findAll().size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(owner.getId())).thenReturn(Optional.of(owner));
        assertNotNull(ownerSDJpaService.findById(owner.getId()));
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).build();

        when(ownerRepository.save(any())).thenReturn(owner);

        Owner savedOwner = ownerSDJpaService.save(ownerToSave);

        assertNotNull(savedOwner);

        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        ownerSDJpaService.delete(owner);

        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        ownerSDJpaService.deleteById(owner.getId());

        verify(ownerRepository, times(1)).deleteById(any());
    }
}
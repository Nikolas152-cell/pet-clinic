package udemy.studying.petclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import udemy.studying.petclinic.model.Owner;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;

    final long ownerId = 1;

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());

        ownerServiceMap.save(Owner.builder().id(ownerId).lastName("Pupkin").build());
    }

    @Test
    void findAll() {
        assertEquals(1, ownerServiceMap.findAll().size());
    }

    @Test
    void findById() {
        assertEquals(ownerId, ownerServiceMap.findById(ownerId).getId());
    }

    @Test
    void saveExistingId() {
        Long id = 2l;

        Owner savedOwner2 = ownerServiceMap.save(Owner.builder().id(id).build());
        assertEquals(id, savedOwner2.getId());
    }

    @Test
    void saveNoId() {
        Owner noIdOwner =  ownerServiceMap.save(Owner.builder().build());

        assertNotNull(noIdOwner);
        assertNotNull(noIdOwner.getId());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));

        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerId);
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void findByLastName() {
        assertNotNull(ownerServiceMap.findByLastName("Pupkin"));
    }
}
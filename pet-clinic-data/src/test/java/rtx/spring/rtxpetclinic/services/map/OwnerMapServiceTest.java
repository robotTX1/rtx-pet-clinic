package rtx.spring.rtxpetclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rtx.spring.rtxpetclinic.model.Owner;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    private OwnerMapService ownerMapService;

    private final Long ownerId = 1L;
    private final String ownerLastName = "Smith";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());

        ownerMapService.save(Owner.builder().id(ownerId).lastName(ownerLastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();

        assertEquals(1, ownerSet.size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);

        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));

        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void save() {
        Long ownerId2 = 2L;
        Owner savedOwner = ownerMapService.save(Owner.builder().id(ownerId2).build());

        assertNotNull(savedOwner);
        assertEquals(ownerId2, savedOwner.getId());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);

        assertNotNull(owner);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerMapService.findByLastName(ownerLastName);

        assertNotNull(owner);
        assertEquals(ownerId, owner.getId());
        assertEquals(ownerLastName, owner.getLastName());
    }
}
package rtx.spring.rtxpetclinic.services.map;

import org.springframework.stereotype.Service;
import rtx.spring.rtxpetclinic.model.Owner;
import rtx.spring.rtxpetclinic.model.Pet;
import rtx.spring.rtxpetclinic.services.OwnerService;
import rtx.spring.rtxpetclinic.services.PetService;
import rtx.spring.rtxpetclinic.services.PetTypeService;

import java.util.Map;
import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {
        if(object != null) {
            if(object.getPets() != null) {
                object.getPets().forEach(pet -> {
                    if(pet.getPetType() != null) {
                        if(pet.getPetType().getId() == null) {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("Pet Type is required");
                    }

                    if(pet.getId() == null) {
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }

            return super.save(object);
        } else {
            return null;
        }
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        Owner owner = null;

        for(Map.Entry<Long, Owner> entry : super.map.entrySet()) {
            if(entry.getValue().getLastName().equals(lastName)) {
                owner = entry.getValue();
                break;
            }
        }

        return owner;
    }
}

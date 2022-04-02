package rtx.spring.rtxpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import rtx.spring.rtxpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}

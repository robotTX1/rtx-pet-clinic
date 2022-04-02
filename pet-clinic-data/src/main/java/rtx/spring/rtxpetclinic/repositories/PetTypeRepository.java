package rtx.spring.rtxpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import rtx.spring.rtxpetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}

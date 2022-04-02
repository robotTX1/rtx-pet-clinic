package rtx.spring.rtxpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import rtx.spring.rtxpetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}

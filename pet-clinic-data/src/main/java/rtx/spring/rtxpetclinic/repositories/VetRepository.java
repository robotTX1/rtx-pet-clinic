package rtx.spring.rtxpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import rtx.spring.rtxpetclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}

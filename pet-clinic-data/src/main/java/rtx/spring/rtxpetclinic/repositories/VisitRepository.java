package rtx.spring.rtxpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import rtx.spring.rtxpetclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}

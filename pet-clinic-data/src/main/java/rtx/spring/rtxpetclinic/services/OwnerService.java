package rtx.spring.rtxpetclinic.services;

import rtx.spring.rtxpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}

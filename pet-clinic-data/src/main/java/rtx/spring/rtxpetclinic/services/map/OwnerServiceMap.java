package rtx.spring.rtxpetclinic.services.map;

import org.springframework.stereotype.Service;
import rtx.spring.rtxpetclinic.model.Owner;
import rtx.spring.rtxpetclinic.services.OwnerService;

import java.util.Map;
import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
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
        return super.save(object.getId(), object);
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

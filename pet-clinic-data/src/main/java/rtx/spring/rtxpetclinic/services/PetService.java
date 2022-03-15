package rtx.spring.rtxpetclinic.services;

import rtx.spring.rtxpetclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}

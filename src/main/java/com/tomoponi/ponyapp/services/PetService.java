package com.tomoponi.ponyapp.services;

import com.tomoponi.ponyapp.model.Pet;
import com.tomoponi.ponyapp.repository.PetRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PetService {
    final PetRepository petRepository;

    @Autowired
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    // get all pets
    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    // get a pet with a given name
    @Transactional(rollbackOn = {NoSuchElementException.class})
    public Pet findByPetName(String name) throws NoSuchElementException {
        return petRepository.findByNameIgnoreCase(name).orElseThrow();
    }

    // create or update a pet
    public void saveOrUpdatePet(Pet p) {
        petRepository.save(p);
        log.info(p.toString());
    }

    // delete a pet, you monster
    public void deletePet(Pet p) {
        petRepository.delete(p);
    }
}

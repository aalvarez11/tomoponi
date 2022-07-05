package com.tomoponi.ponyapp.repository;

import com.tomoponi.ponyapp.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    Optional<Pet> findByNameIgnoreCase(String name);

    List<Pet> findPetsByUserId(int userId);
}

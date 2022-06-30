package com.tomoponi.ponyapp.repository;

import com.tomoponi.ponyapp.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    Optional<Item> findByNameIgnoreCase(String name);
}

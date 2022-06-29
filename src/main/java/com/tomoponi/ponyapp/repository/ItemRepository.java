package com.tomoponi.ponyapp.repository;

import com.tomoponi.ponyapp.model.Item;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@NoRepositoryBean
public interface ItemRepository extends JpaRepository<Item, Integer> {
    Optional<Item> findByName(String name);
}

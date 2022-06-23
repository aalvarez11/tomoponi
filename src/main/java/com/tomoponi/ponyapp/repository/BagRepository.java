package com.tomoponi.ponyapp.repository;

import com.tomoponi.ponyapp.model.Bag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BagRepository extends JpaRepository<Bag, Integer> {

}

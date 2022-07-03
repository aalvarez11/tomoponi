package com.tomoponi.ponyapp.repository;

import com.tomoponi.ponyapp.model.AuthGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthGroupRepository extends JpaRepository<AuthGroup, Integer> {
    List<AuthGroup> findByAuEmail(String email);
}
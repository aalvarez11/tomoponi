package com.tomoponi.ponyapp.repository;

import com.tomoponi.ponyapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
    @Query(value = "SELECT * FROM user u WHERE u.email = :email", nativeQuery = true)
    Optional<User> findByEmail(String email);
}

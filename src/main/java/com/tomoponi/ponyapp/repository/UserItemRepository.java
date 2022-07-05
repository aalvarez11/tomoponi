package com.tomoponi.ponyapp.repository;

import com.tomoponi.ponyapp.model.UserItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserItemRepository extends JpaRepository<UserItems, Long> {
    List<UserItems> findUserItemsByUserId(int userId);
}

package com.tomoponi.ponyapp.services;

import com.tomoponi.ponyapp.model.Item;
import com.tomoponi.ponyapp.model.Pet;
import com.tomoponi.ponyapp.model.User;
import com.tomoponi.ponyapp.repository.PetRepository;
import com.tomoponi.ponyapp.repository.UserRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@Transactional(rollbackOn = {DataAccessException.class})
public class UserService {
    final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // get all users in the database
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // get a user by their id
    @Transactional(rollbackOn = {NoSuchElementException.class})
    public User findById(int userId) throws NoSuchElementException {
        return userRepository.findById(userId).orElseThrow();
    }

    @Transactional(rollbackOn = {NoSuchElementException.class})
    public User findByEmail(String email) throws NoSuchElementException {
        return userRepository.findByEmail(email).orElseThrow();
    }

    // get a user by their username
    @Transactional(rollbackOn = {NoSuchElementException.class})
    public User findByUsername(String username) throws NoSuchElementException {
        return userRepository.findByUsername(username).orElseThrow();
    }

    // save a new user or update an existing one
    @Transactional(rollbackOn = {NoSuchElementException.class})
    public void saveOrUpdate(User u) {
        log.info(u.toString());
        // check if the user exists in the database
        if (userRepository.existsById(u.getId())) {
            // user is in the database, so just update their info
            userRepository.save(u);
            log.warn("user exists" + u.toString());
        } else {
            // user is not in the database, save the user and their new bag
            userRepository.save(u);
            log.warn("user didn't exist " + u.toString());
        }
    }

    // delete a user from the database
    public void deleteUser(User u) {
        userRepository.delete(u);
    }

    // adding an item with 1 of said item
    @Transactional(rollbackOn = {NoSuchElementException.class})
    public void addItem(int userId, Item item) throws NoSuchElementException {
        User u = userRepository.findById(userId).orElseThrow();
        u.addItem(item);
        userRepository.save(u);
    }

    // adding an item with more than 1 of said item
    @Transactional(rollbackOn = {NoSuchElementException.class})
    public void addMultipleOfItem(int userId, Item item, int qty) throws NoSuchElementException {
        User u = userRepository.findById(userId).orElseThrow();
        u.addMultipleOfItem(item, qty);
        userRepository.save(u);
    }

    // add a pet to a user
    @Transactional(rollbackOn = {NoSuchElementException.class})
    public void addPet(int userId, Pet pet) throws NoSuchElementException {
        User u = userRepository.findById(userId).orElseThrow();
        pet.setUser(u);
        u.addPet(pet);
        userRepository.save(u);
    }
}

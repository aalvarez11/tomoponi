package com.tomoponi.ponyapp.services;

import com.tomoponi.ponyapp.model.AuthGroup;
import com.tomoponi.ponyapp.model.Item;
import com.tomoponi.ponyapp.model.Pet;
import com.tomoponi.ponyapp.model.User;
import com.tomoponi.ponyapp.repository.AuthGroupRepository;
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
    final AuthGroupRepository authGroupRepository;

    @Autowired
    public UserService(UserRepository userRepository, AuthGroupRepository authGroupRepository) {
        this.userRepository = userRepository;
        this.authGroupRepository = authGroupRepository;
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
        log.info("email fetched was: " + email);
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
        userRepository.save(u);
        authGroupRepository.save(new AuthGroup(u.getEmail(), "ROLE_USER"));
    }

    // save an admin_role user
    @Transactional(rollbackOn = {NoSuchElementException.class})
    public void saveOrUpdateAdmin(User u) {
        log.info(u.toString());
        userRepository.save(u);
        authGroupRepository.save(new AuthGroup(u.getEmail(), "ROLE_ADMIN"));
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

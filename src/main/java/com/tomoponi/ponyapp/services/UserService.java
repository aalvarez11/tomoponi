package com.tomoponi.ponyapp.services;

import com.tomoponi.ponyapp.model.Bag;
import com.tomoponi.ponyapp.model.User;
import com.tomoponi.ponyapp.repository.BagRepository;
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
    final BagRepository bagRepository;

    @Autowired
    public UserService(UserRepository userRepository, BagRepository bagRepository) {
        this.userRepository = userRepository;
        this.bagRepository = bagRepository;
    }

    // get all users in the database
    public List<User> findAll() {
        return userRepository.findAll();
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
            log.warn("user id is now: " + u.getId());
            u.setBag(new Bag(u.getId(), 0));
            userRepository.save(u);
            log.warn("user doesn't exist" + u.toString());
        }
    }

    // delete a user from the database
    public void deleteUser(User u) {
        userRepository.delete(u);
    }
}

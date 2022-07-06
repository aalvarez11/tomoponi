package com.tomoponi.ponyapp;

import com.tomoponi.ponyapp.model.User;
import com.tomoponi.ponyapp.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
class UserRepoTests {
    @Autowired
    private UserRepository userRepository;

    private User user;

    @BeforeEach
    public void setup() {
        user = new User("test_user", "test@psmail.com", "password", 0);
    }

    @Test
    void testCreateNewUser() {
        User savedUser = userRepository.save(user);
        assertThat(savedUser).isNotNull();
    }
}

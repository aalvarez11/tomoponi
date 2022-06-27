package com.tomoponi.ponyapp;

import com.tomoponi.ponyapp.model.User;
import com.tomoponi.ponyapp.services.UserService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppCommandLineRunner implements CommandLineRunner {
    final UserService userService;
    static final String PASSWORD = "password";

    @Autowired
    public AppCommandLineRunner(UserService userService) {
        this.userService = userService;
    }

    // log a message when the constructor runs
    @PostConstruct
    public void postConstruct() {
        log.warn("=========== Tomoponi CommandLine Runner ===========");
    }


    @Override
    public void run(String... args) throws Exception {
        // create some sample users in the database
        userService.saveOrUpdate(new User("xXdragonXx", "wer@psmail.com", PASSWORD, 0));
        userService.saveOrUpdate(new User("Oprah_Rulez", "oown@psmail.com", PASSWORD, 100));
        userService.saveOrUpdate(new User("020nion","0nion@psmail.com", PASSWORD, 0));
        userService.saveOrUpdate(new User("b3n4css", "xosn@psmail.com", PASSWORD, 200));

        // create some sample items in the database

    }
}

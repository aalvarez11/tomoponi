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
        userService.saveOrUpdate(new User("sd2nso", "wer@gmail.com", PASSWORD));
        userService.saveOrUpdate(new User("23nxx023n", "oown@gmail.com", PASSWORD));
        userService.saveOrUpdate(new User("020nion","0nion@gmail.com", PASSWORD));
        userService.saveOrUpdate(new User("b3n4css", "xosn@gmail.com", PASSWORD));
    }
}

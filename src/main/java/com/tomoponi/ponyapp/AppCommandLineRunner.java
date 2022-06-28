package com.tomoponi.ponyapp;

import com.tomoponi.ponyapp.model.Egg;
import com.tomoponi.ponyapp.model.ElementType;
import com.tomoponi.ponyapp.model.Food;
import com.tomoponi.ponyapp.model.User;
import com.tomoponi.ponyapp.services.ItemService;
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
    final ItemService itemService;
    static final String PASSWORD = "password";

    @Autowired
    public AppCommandLineRunner(UserService userService, ItemService itemService) {
        this.userService = userService;
        this.itemService = itemService;
    }

    // log a message when the constructor runs
    @PostConstruct
    public void postConstruct() {
        log.warn("=========== Tomoponi CommandLine Runner ===========");
    }


    @Override
    public void run(String... args) throws Exception {
        // create some sample users in the database
        userService.saveOrUpdate(new User("xXdragonXx", "werfer@psmail.com", PASSWORD, 0));
        userService.saveOrUpdate(new User("Oprah_Rulez", "oown@psmail.com", PASSWORD, 100));
        userService.saveOrUpdate(new User("020nion","0nion@psmail.com", PASSWORD, 0));
        userService.saveOrUpdate(new User("bena_css", "xosn@psmail.com", PASSWORD, 200));

        // create some sample items in the database
        itemService.saveOrUpdateEgg(new Egg("Fire Egg",
                "An egg imbued with the power of Fire",
                "/resources/images/fireegg.jpeg",
                500,
                125,
                30,
                ElementType.FIRE));
        itemService.saveOrUpdateFood(new Food("",
                "",
                "",
                50,
                10,
                3));
        itemService.saveOrUpdateEgg(new Egg("Water Egg",
                "An egg imbued with the power of Water",
                "/resources/images/wateregg.jpeg",
                500,
                125,
                30,
                ElementType.WATER));
        itemService.saveOrUpdateEgg(new Egg("Light Egg",
                "An egg imbued with the power of Light",
                "/resources/images/lightegg.jpeg",
                500,
                125,
                30,
                ElementType.LIGHT));
        itemService.saveOrUpdateEgg(new Egg("Thunder Egg",
                "An egg imbued with the power of Thunder",
                "/resources/images/thunderegg.jpeg",
                500,
                125,
                30,
                ElementType.THUNDER));
        itemService.saveOrUpdateEgg(new Egg("Earth Egg",
                "An egg imbued with the power of Earth",
                "/resources/images/earthegg.jpeg",
                500,
                125,
                30,
                ElementType.EARTH));
        itemService.saveOrUpdateEgg(new Egg("Dark Egg",
                "An egg imbued with the power of Darkness",
                "/resources/images/darkegg.jpeg",
                500,
                125,
                30,
                ElementType.DARK));
    }
}

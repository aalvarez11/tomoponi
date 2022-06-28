package com.tomoponi.ponyapp;

import com.tomoponi.ponyapp.model.*;
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
        userService.saveOrUpdate(new User("Sunny Bun", "starscout@psmail.com", PASSWORD, 200));

        // create some sample items in the database
        itemService.saveOrUpdateEgg(new Egg("Fire Egg",
                "An egg imbued with the power of Fire",
                "/resources/images/fireegg.jpeg",
                500,
                125,
                30,
                ElementType.FIRE));
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
        itemService.saveOrUpdateFood(new Food("Pancakes",
                "A stack of fluffy pancakes with syrup",
                "/resources/static/images/pancakes.jpeg",
                75,
                15,
                5));
        itemService.saveOrUpdateFood(new Food("Cheese Pizza",
                "A tasty pizza topped with multiple cheeses",
                "/resources/static/images/pizza.jpeg",
                100,
                25,
                8));
        itemService.saveOrUpdateFood(new Food("Apple",
                "A crisp and juicy apple",
                "/resources/static/images/apple.jpeg",
                50,
                10,
                3));
        itemService.saveOrUpdateFood(new Food("Orange",
                "A sweet and juicy orange",
                "/resources/static/images/orange.jpeg",
                50,
                10,
                3));
        itemService.saveOrUpdateMedicine(new Medicine("Small Potion",
                "A weak drinkable solution for healing wounds",
                "/resources/static/images/smpotion.jpeg",
                50,
                10,
                5));
        itemService.saveOrUpdateMedicine(new Medicine("Potion",
                "A drinkable solution for healing wounds",
                "/resources/static/images/potion.jpeg",
                100,
                25,
                10));
        itemService.saveOrUpdateMedicine(new Medicine("Large Potion",
                "A strong drinkable solution for healing wounds",
                "/resources/static/images/lgpotion.jpeg",
                150,
                50,
                20));
        itemService.saveOrUpdateToy(new Toy("Ball",
                "A bouncy rubber ball",
                "/resources/static/images/toyball.jpeg",
                50,
                10,
                5));
        itemService.saveOrUpdateToy(new Toy("Book",
                "A hardcover storybook",
                "/resources/static/images/book.jpeg",
                75,
                15,
                10));
        itemService.saveOrUpdateToy(new Toy("Piano",
                "A baby grand piano for playing or practicing",
                "/resources/static/images/piano.jpeg",
                150,
                50,
                25));
    }
}

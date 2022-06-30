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
        itemService.saveOrUpdateItem(new Egg("Fire Egg",
                "An egg imbued with the power of Fire",
                "/resources/static/assets/fireegg.jpeg",
                500,
                125,
                30,
                ElementType.FIRE));
        itemService.saveOrUpdateItem(new Egg("Water Egg",
                "An egg imbued with the power of Water",
                "/resources/static/assets/wateregg.jpeg",
                500,
                125,
                30,
                ElementType.WATER));
        itemService.saveOrUpdateItem(new Egg("Light Egg",
                "An egg imbued with the power of Light",
                "/resources/static/assets/lightegg.jpeg",
                500,
                125,
                30,
                ElementType.LIGHT));
        itemService.saveOrUpdateItem(new Egg("Thunder Egg",
                "An egg imbued with the power of Thunder",
                "/resources/static/assets/thunderegg.jpeg",
                500,
                125,
                30,
                ElementType.THUNDER));
        itemService.saveOrUpdateItem(new Egg("Earth Egg",
                "An egg imbued with the power of Earth",
                "/resources/static/assets/earthegg.jpeg",
                500,
                125,
                30,
                ElementType.EARTH));
        itemService.saveOrUpdateItem(new Egg("Dark Egg",
                "An egg imbued with the power of Darkness",
                "/resources/static/assets/darkegg.jpeg",
                500,
                125,
                30,
                ElementType.DARK));
        itemService.saveOrUpdateItem(new Food("Pancakes",
                "A stack of fluffy pancakes with syrup",
                "/resources/static/assets/pancakes.jpeg",
                75,
                15,
                5));
        itemService.saveOrUpdateItem(new Food("Cheese Pizza",
                "A tasty pizza topped with multiple cheeses",
                "/resources/static/assets/pizza.jpeg",
                100,
                25,
                8));
        itemService.saveOrUpdateItem(new Food("Apple",
                "A crisp and juicy apple",
                "/resources/static/assets/apple.jpeg",
                50,
                10,
                3));
        itemService.saveOrUpdateItem(new Food("Orange",
                "A sweet and juicy orange",
                "/resources/static/assets/orange.jpeg",
                50,
                10,
                3));
        itemService.saveOrUpdateItem(new Medicine("Small Potion",
                "A weak drinkable solution for healing wounds",
                "/resources/static/assets/smpotion.jpeg",
                50,
                10,
                5));
        itemService.saveOrUpdateItem(new Medicine("Potion",
                "A drinkable solution for healing wounds",
                "/resources/static/assets/potion.jpeg",
                100,
                25,
                10));
        itemService.saveOrUpdateItem(new Medicine("Large Potion",
                "A strong drinkable solution for healing wounds",
                "/resources/static/assets/lgpotion.jpeg",
                150,
                50,
                20));
        itemService.saveOrUpdateItem(new Toy("Ball",
                "A bouncy rubber ball",
                "/resources/static/assets/toyball.jpeg",
                50,
                10,
                5));
        itemService.saveOrUpdateItem(new Toy("Book",
                "A hardcover storybook",
                "/resources/static/assets/book.jpeg",
                75,
                15,
                10));
        itemService.saveOrUpdateItem(new Toy("Piano",
                "A baby grand piano for playing or practicing",
                "/resources/static/assets/piano.jpeg",
                150,
                50,
                25));
        itemService.saveOrUpdateItem(new Toy("Paints",
                "A painting kit with all sorts of colors and tools",
                "/resources/static/assets/paints.jpeg",
                100,
                20,
                15));

        // giving some items to users
        userService.addItem(1, itemService.findByItemName("Ball"));
        userService.addMultipleOfItem(2, itemService.findByItemName("Potion"), 5);

        // give a user a pet
        userService.addPet(1, new Pet("Spike",
                "/resources/static/assets/pets/spike.gif",
                1, 100, 100, 100, ElementType.FIRE));
        userService.addPet(3, new Pet("Silverstream",
                "/resources/static/assets/pets/silverstream.gif",
                1, 100, 100, 100, ElementType.WATER));

    }
}

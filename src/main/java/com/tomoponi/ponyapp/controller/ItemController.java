package com.tomoponi.ponyapp.controller;

import com.tomoponi.ponyapp.model.Item;
import com.tomoponi.ponyapp.model.User;
import com.tomoponi.ponyapp.model.UserItems;
import com.tomoponi.ponyapp.services.ItemService;
import com.tomoponi.ponyapp.services.UserItemService;
import com.tomoponi.ponyapp.services.UserService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping(value = "items")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ItemController {
    final UserService userService;
    final ItemService itemService;
    final UserItemService userItemService;

    @Autowired
    public ItemController(UserService userService, ItemService itemService, UserItemService userItemService) {
        this.userService = userService;
        this.itemService = itemService;
        this.userItemService = userItemService;
    }

    @GetMapping("/view_items")
    public String showItems(Model model, Principal principal) {
        // first fetch the user according to the principal
        User currUser = userService.findByEmail(principal.getName());

        // get the list of items using the userId
        List<UserItems> currUserItems = userItemService.findUserItemsByUserId(currUser.getId());

        // construct a list of items based off of the given userItems list
        List<Item> itemList = new ArrayList<>();

        for (UserItems userItem : currUserItems) {
            Item temp = itemService.findById(userItem.getItem().getId());
            itemList.add(temp);
        }

        // add both lists to the model
        model.addAttribute("UserItems", currUserItems);
        model.addAttribute("Items", itemList);

        return "items";
    }
}

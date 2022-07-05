package com.tomoponi.ponyapp.controller;

import com.tomoponi.ponyapp.model.Pet;
import com.tomoponi.ponyapp.model.User;
import com.tomoponi.ponyapp.services.PetService;
import com.tomoponi.ponyapp.services.UserService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Slf4j
@Controller
@RequestMapping(value = "pets")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PetController {
    final PetService petService;
    final UserService userService;

    public PetController(PetService petService, UserService userService) {
        this.petService = petService;
        this.userService = userService;
    }

    @GetMapping("/view_pets")
    public String showPets(Model model, Principal principal) {
        // first get the current user
        log.info("principal is " + principal.getName());
        User currUser = userService.findByEmail(principal.getName());
        log.info("current user is " + currUser.toString());

        // find which pets belong to the user
        List<Pet> currUserPets = petService.findPetsByUserId(currUser.getId());

        // add the list to the model
        model.addAttribute("listPets", currUserPets);

        return "pets";
    }

}

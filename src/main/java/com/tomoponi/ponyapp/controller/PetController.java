package com.tomoponi.ponyapp.controller;

import com.tomoponi.ponyapp.services.PetService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping(value = "pets")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PetController {
    final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/view_pets")
    public String showPets() {
        return "pets";
    }
}

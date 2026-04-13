package com.github.laertty.sistema_cadastro_pets.controller;

import com.github.laertty.sistema_cadastro_pets.model.entities.Pet;
import com.github.laertty.sistema_cadastro_pets.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping
    public ResponseEntity findAll() {
        List<Pet> pets = petService.findAll();
        return ResponseEntity.ok().body(pets);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pet> findById(@PathVariable Integer id) {
        Pet pet = petService.findById(id);
        return ResponseEntity.ok().body(pet);
    }

}

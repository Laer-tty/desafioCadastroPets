package com.github.laertty.sistema_cadastro_pets.controller;

import com.github.laertty.sistema_cadastro_pets.model.entities.Pet;
import com.github.laertty.sistema_cadastro_pets.model.vo.Idade;
import com.github.laertty.sistema_cadastro_pets.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pet> findById(@PathVariable Integer id) {
        Pet pet = petService.findById(id);
        return ResponseEntity.ok().body(pet);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity insert(@RequestBody Pet pet) {
        petService.insert(pet);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(pet.getId())
                .toUri();

        return ResponseEntity.ok().body(pet);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody Pet pet, @PathVariable Integer id) {

        Pet petAtualizado = petService.update(id, pet);

        return ResponseEntity.ok().body(petAtualizado);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        petService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/buscar", method = RequestMethod.GET)
    public ResponseEntity<List<Pet>> buscarNomeIdade(@RequestParam String nome) {
        List<Pet> pets = petService.findByNome(nome);
        return ResponseEntity.ok(pets);
    }
}
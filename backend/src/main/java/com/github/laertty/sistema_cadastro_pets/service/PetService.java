package com.github.laertty.sistema_cadastro_pets.service;

import com.github.laertty.sistema_cadastro_pets.model.entities.Pet;
import com.github.laertty.sistema_cadastro_pets.repository.PetRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public void save(Pet pet) {
        petRepository.save(pet);
    }

    public List<Pet> findAll() {
        return (List<Pet>) petRepository.findAll();
    }

    public Pet findById(Integer id) {
        Optional<Pet> pet = petRepository.findById(id);
        return pet.orElseThrow(() -> new PetNotFoundException("Pet não encontrado."));
    }

    @Transactional
    public void delete(Integer id) {
        petRepository.deleteById(id);
    }

}

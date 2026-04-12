package com.github.laertty.sistema_cadastro_pets.service;

import com.github.laertty.sistema_cadastro_pets.model.entities.Pet;
import com.github.laertty.sistema_cadastro_pets.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public List<Pet> findAll() {
        return (List<Pet>) petRepository.findAll();
    }

}

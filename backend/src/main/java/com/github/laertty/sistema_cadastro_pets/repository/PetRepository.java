package com.github.laertty.sistema_cadastro_pets.repository;


import com.github.laertty.sistema_cadastro_pets.model.entities.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {}


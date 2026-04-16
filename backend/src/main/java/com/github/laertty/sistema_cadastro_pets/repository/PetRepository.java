package com.github.laertty.sistema_cadastro_pets.repository;

import com.github.laertty.sistema_cadastro_pets.model.entities.Pet;
import com.github.laertty.sistema_cadastro_pets.model.vo.Idade;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PetRepository extends CrudRepository<Pet, Integer> {

    List<Pet> findByNomeContainingIgnoreCase(String nome);

}


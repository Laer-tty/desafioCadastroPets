package com.github.laertty.sistema_cadastro_pets.service;

import com.github.laertty.sistema_cadastro_pets.model.entities.Pet;
import com.github.laertty.sistema_cadastro_pets.repository.PetRepository;
import com.github.laertty.sistema_cadastro_pets.service.exceptions.PetNomeInvalidoException;
import com.github.laertty.sistema_cadastro_pets.service.exceptions.PetNotFoundException;
import com.github.laertty.sistema_cadastro_pets.service.exceptions.PetPesoInvalidoException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public List<Pet> findAll() {
        return (List<Pet>) petRepository.findAll();
    }

    public Pet findById(Integer id) {
        Optional<Pet> pet = petRepository.findById(id);
        return pet.orElseThrow(() -> new PetNotFoundException("Pet não encontrado."));
    }

    public void delete(Integer id) {

        findById(id);

        petRepository.deleteById(id);
    }

    public Pet insert(Pet pet) {
        pet.setId(null);
        validarPet(pet);
        return petRepository.save(pet);
    }

    private Pet validarPet(Pet pet) {
        if (pet.getNome() == null || !pet.getNome().trim().contains(" ")) {
            throw new PetNomeInvalidoException("O pet deve ter nome e sobrenome completo.");
        }

        if (!pet.getNome().matches("^[a-zA-ZÁ-ú\\s]+$")) {
            throw new PetNomeInvalidoException("O nome não pode conter caracteres especiais");
        }

        if (pet.getPeso() > 60.0 || pet.getPeso() < 0.5) {
            throw new PetPesoInvalidoException("O peso deve ser menor que 60kg e maior que 0.5kg.");
        }

        if (!pet.getRaca().matches("^[a-zA-ZÁ-ú\\s]+$")) {
            throw new PetNomeInvalidoException("A raça não pode conter caracteres especiais");
        }

        return pet;
    }

}

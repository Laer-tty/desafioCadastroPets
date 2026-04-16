package com.github.laertty.sistema_cadastro_pets.service;

import com.github.laertty.sistema_cadastro_pets.model.entities.Pet;
import com.github.laertty.sistema_cadastro_pets.model.vo.Idade;
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

    public Pet insert(Pet pet) {
        pet.setId(null);
        validarPet(pet);
        return petRepository.save(pet);
    }

    public void delete(Integer id) {
        findById(id);
        petRepository.deleteById(id);
    }

    public Pet update(Integer id, Pet source) {
        Pet target = findById(id);
        validarPet(source);
        updateData(target, source);
        return petRepository.save(source);
    }

    public List<Pet> findByNome(String nome) {
        return petRepository.findByNomeContainingIgnoreCase(nome);
    }

    private Pet updateData(Pet target, Pet source) {
        target.setNome(source.getNome());
        target.setAnos(source.getAnos());
        target.setEndereco(source.getEndereco());
        target.setRaca(source.getRaca());
        target.setPeso(source.getPeso());
        target.setGenero(source.getGenero());
        target.setTipo(source.getTipo());
        return target;
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

package com.github.laertty.sistema_cadastro_pets.config;

import com.github.laertty.sistema_cadastro_pets.model.entities.Pet;
import com.github.laertty.sistema_cadastro_pets.model.enums.Genero;
import com.github.laertty.sistema_cadastro_pets.model.enums.Tipo;
import com.github.laertty.sistema_cadastro_pets.model.vo.Endereco;
import com.github.laertty.sistema_cadastro_pets.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;


@Configuration
public class Tester implements CommandLineRunner {

    @Autowired
    private PetRepository petRepository;

    @Override
    public void run(String... args) throws Exception {

        petRepository.deleteAll();

        Endereco end1 = new Endereco("Rua 1", 123, "Cidade 1");
        Endereco end2 = new Endereco("Rua 2", 456, "Seilandia");

        Pet pet1 = new Pet(null, "Rex", Tipo.CACHORRO, Genero.MACHO, end1, 2, 5.0, "Vira-lata");
        Pet pet2 = new Pet(null, "Florzinha da Silva", Tipo.GATO, Genero.FEMEA, end2, 6, 5.0, "Siames");

        petRepository.saveAll(Arrays.asList(pet1, pet2));
    }
}

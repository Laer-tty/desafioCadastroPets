package com.github.laertty.sistema_cadastro_pets.model.entities;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import com.github.laertty.sistema_cadastro_pets.model.vo.Endereco;
import com.github.laertty.sistema_cadastro_pets.model.enums.Genero;
import com.github.laertty.sistema_cadastro_pets.model.enums.Tipo;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_pet")
public class Pet implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    @Embedded
    private Endereco endereco;

    private Integer idade;

    private Double peso;

    private String raca;

}

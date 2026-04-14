package com.github.laertty.sistema_cadastro_pets.model.entities;

import com.github.laertty.sistema_cadastro_pets.model.vo.Idade;
import jakarta.persistence.*;
import lombok.*;
import com.github.laertty.sistema_cadastro_pets.model.vo.Endereco;
import com.github.laertty.sistema_cadastro_pets.model.enums.Genero;
import com.github.laertty.sistema_cadastro_pets.model.enums.Tipo;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tb_pet")
public class Pet implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    @Embedded
    private Endereco endereco;

    private Idade anos;

    private Double peso;

    private String raca;

}

package com.github.laertty.sistema_cadastro_pets.model.vo;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Endereco {

    private String rua;

    private Integer numeroDaCasa;

    private String cidade;

}

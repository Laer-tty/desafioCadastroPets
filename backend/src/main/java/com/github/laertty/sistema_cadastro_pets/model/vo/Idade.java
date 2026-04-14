package com.github.laertty.sistema_cadastro_pets.model.vo;

import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class Idade {

    private Integer ano;

    private Integer mes;
}

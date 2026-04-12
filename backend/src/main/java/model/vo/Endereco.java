package model.vo;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Endereco {

    private String rua;

    private Integer numeroDaCasa;

    private String cidade;

}

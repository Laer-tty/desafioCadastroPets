package com.github.laertty.sistema_cadastro_pets.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PetNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public PetNotFoundException(String mensagem) {
        super(mensagem);
    }
}

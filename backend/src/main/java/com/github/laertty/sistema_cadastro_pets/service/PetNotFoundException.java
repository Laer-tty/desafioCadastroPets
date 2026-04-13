package com.github.laertty.sistema_cadastro_pets.service;

import java.io.Serial;

public class PetNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public PetNotFoundException(String mensagem) {
        super(mensagem);
    }
}

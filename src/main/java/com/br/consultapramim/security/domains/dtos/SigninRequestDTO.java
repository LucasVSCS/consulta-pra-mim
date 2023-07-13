package com.br.consultapramim.security.domains.dtos;

import jakarta.validation.constraints.NotBlank;

import java.io.Serial;
import java.io.Serializable;

public class SigninRequestDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @NotBlank(message = "Nome de usuário é obrigatório")
    private String username;
    @NotBlank(message = "Senha é obrigatório")
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

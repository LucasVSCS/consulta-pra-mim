package com.br.consultapramim.security.services;

import com.br.consultapramim.application.utils.MessageResponse;
import com.br.consultapramim.security.domains.dtos.JwtAuthenticationResponseDTO;
import com.br.consultapramim.security.domains.dtos.SigninRequestDTO;
import com.br.consultapramim.security.domains.dtos.SignupRequestDTO;

public interface AuthenticationService {
    MessageResponse signup(SignupRequestDTO request);

    JwtAuthenticationResponseDTO signin(SigninRequestDTO request);
}

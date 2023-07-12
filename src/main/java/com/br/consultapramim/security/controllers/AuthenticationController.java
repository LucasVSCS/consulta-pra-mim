package com.br.consultapramim.security.controllers;

import com.br.consultapramim.application.utils.MessageResponse;
import com.br.consultapramim.security.domains.dtos.JwtAuthenticationResponseDTO;
import com.br.consultapramim.security.domains.dtos.SigninRequestDTO;
import com.br.consultapramim.security.domains.dtos.SignupRequestDTO;
import com.br.consultapramim.security.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/signup")
    public MessageResponse signup(@RequestBody SignupRequestDTO request) {
        return authenticationService.signup(request);
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponseDTO> signin(@RequestBody SigninRequestDTO request) {
        return ResponseEntity.ok(authenticationService.signin(request));
    }
}

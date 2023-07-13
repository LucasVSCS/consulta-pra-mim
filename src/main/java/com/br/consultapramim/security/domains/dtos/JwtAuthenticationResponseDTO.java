package com.br.consultapramim.security.domains.dtos;

import java.util.List;

public record JwtAuthenticationResponseDTO(Long userId, String username, String email, String jwtToken,
                                           List<String> roles) {
}

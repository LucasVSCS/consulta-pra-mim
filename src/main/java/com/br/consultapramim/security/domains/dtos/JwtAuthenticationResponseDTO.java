package com.br.consultapramim.security.domains.dtos;

import java.util.List;

public class JwtAuthenticationResponseDTO {
    private String jwtToken;
    private Long userId;
    private String username;
    private String email;
    private List<String> roles;

    public JwtAuthenticationResponseDTO() {
    }

    public JwtAuthenticationResponseDTO(String jwtToken, Long userId, String username, String email, List<String> roles) {
        this.jwtToken = jwtToken;
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}

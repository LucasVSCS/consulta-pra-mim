package com.br.consultapramim.security.utils;

import com.br.consultapramim.security.services.serviceImpl.UserDetailsServiceImpl;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {
    @Value("${token.signing.key}")
    private String jwtSecret;

    @Value("${token.expiration.time}")
    private int jwtExpirationMs;

    public String generateJwtToken(Authentication authentication) {
        UserDetailsServiceImpl userPrincipal = (UserDetailsServiceImpl) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(key(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parserBuilder().setSigningKey(key()).build()
                .parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parserBuilder().setSigningKey(key()).build().parse(authToken);

            return true;
        } catch (MalformedJwtException e) {
            throw new MalformedJwtException("Token JWT Inválido");
        } catch (ExpiredJwtException e) {
            throw new ExpiredJwtException(null, null, "Token JWT expirado");
        } catch (UnsupportedJwtException e) {
            throw new UnsupportedJwtException("Token JWT não suportado");
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Claims JWT está vazia");
        }

    }
}

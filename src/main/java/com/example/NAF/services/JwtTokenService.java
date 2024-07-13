package com.example.NAF.services;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
public class JwtTokenService {

//    private static final String SECRET_KEY = "naf-secret-key";
    private static final Key KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);;

    public String generateToken(String userId) {
        return Jwts.builder()
                .setSubject(userId)
                .signWith(KEY, SignatureAlgorithm.HS256)
                .compact();
    }

    public String parseToken(String token) {
        try {
            Jws<Claims> jws = Jwts.parserBuilder()
                    .setSigningKey(KEY)
                    .build()
                    .parseClaimsJws(token);

            return jws.getBody().getSubject();
        } catch (JwtException e) {
            throw new JwtException("Invalid token");
        }
    }
}

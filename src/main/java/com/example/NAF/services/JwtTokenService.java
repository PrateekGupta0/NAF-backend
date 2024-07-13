package com.example.NAF.services;

import com.example.NAF.utils.UserTokenVO;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
public class JwtTokenService {

//    private static final String SECRET_KEY = "naf-secret-key";
    private static final Key KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);;

    public String generateToken(String userId, String role) {
        return Jwts.builder()
                .setSubject(userId+"~"+role)
                .signWith(KEY, SignatureAlgorithm.HS256)
                .compact();
    }

    public UserTokenVO parseToken(String token) {
        try {
            Jws<Claims> jws = Jwts.parserBuilder()
                    .setSigningKey(KEY)
                    .build()
                    .parseClaimsJws(token);

            String bodyRole = jws.getBody().getSubject();
            return new UserTokenVO(bodyRole.split("~")[0], bodyRole.split("~")[1]);
        } catch (JwtException e) {
            throw new JwtException("Invalid token");
        }
    }
}

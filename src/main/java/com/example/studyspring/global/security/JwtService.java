package com.example.studyspring.global.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtService {

    @Value("")
    private String secretKey;

    public String createAccessToken(String value) {
        return createToken(value, "access", 720L);
    }

    public String createToken(String email, String type, Long exp) {
        return Jwts.builder()
                .claim("type", type)
                .setIssuedAt(new Date())
                .setSubject(email)
                .setExpiration(new Date(System.currentTimeMillis() + (exp * 1000L)))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

}

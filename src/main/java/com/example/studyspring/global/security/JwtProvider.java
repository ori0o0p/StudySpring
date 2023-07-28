package com.example.studyspring.global.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Date;

@Component
@Slf4j
@RequiredArgsConstructor
public class JwtProvider {

    @Value("")
    private String secretKey;

    public String createAccessToken(String value) {
        return createToken(value, "access", 720L);
    }

    public String createRefreshToken(String value) {
        return createToken(value, "refresh", 7200L);
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

    public boolean validateToken(String token) {
        try{
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (Exception e){
            log.error("토큰 오류");
        }
        return false;
    }

    public Claims parseClaims(String token){
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();

    }

    public Authentication getAuthentication(String token) {
        Claims claim = parseClaims(token);

        UserDetails details = new User(claim.getSubject(), "", Collections.emptyList());
        return new UsernamePasswordAuthenticationToken(details, "", details.getAuthorities());
    }


}

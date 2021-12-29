package com.adminpanel.adminpanel.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Date;
import java.util.stream.Collectors;

public class JwtTokenProvider {

    @Value("${app.jwt.secret}")
    private String jwtSecret;
    @Value("${app.jwt.token.prefix}")
    private String jwtTokenPrefix;
    @Value("${app.jwt.header.string}")
    private String jwtHeaderString;
    @Value("${app.jwt.expiration-in-ms}")
    private Long jwtExpirationMs;

    public String generateToken(Authentication auth) {
        String authorities = auth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining());
        return Jwts.builder().setSubject(auth.getName())
                .claim("roles", authorities)
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
    }
}

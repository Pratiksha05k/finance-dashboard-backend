package com.financeapp.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtil {

    private static final String SECRET = "mysecretkeymysecretkeymysecretkey123"; // min 32 chars
    private static final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());

    private static final long EXPIRATION = 1000 * 60 * 60; // 1 hour

    // Generate Token
    public static String generateToken(String email, String role) {
        return Jwts.builder()
                .setSubject(email)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(key) 
                .compact();
    }

    // Extract Role
    public static String extractRole(String token) {
        return getClaims(token).get("role", String.class);
    }

    // Extract Email
    public static String extractEmail(String token) {
        return getClaims(token).getSubject();
    }

    // Common method
    private static Claims getClaims(String token) {
        return Jwts.parserBuilder() 
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
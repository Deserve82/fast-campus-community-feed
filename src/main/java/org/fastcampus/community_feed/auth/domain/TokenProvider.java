package org.fastcampus.community_feed.auth.domain;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import javax.crypto.SecretKey;

public class TokenProvider {

    private final String secretKey;
    private static final long TOKEN_VALID_TIME = 1000L * 60 * 60; // 1시간

    public TokenProvider(String secretKey) {
        this.secretKey = secretKey;
    }

    public String createToken(Long userId, String role) {
        Claims claims = Jwts.claims()
                .subject(userId.toString())
                .build();
        Date now = new Date();
        Date validity = new Date(now.getTime() + TOKEN_VALID_TIME);
        SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes());

        return Jwts.builder()
                .claims(claims)
                .issuedAt(now)
                .expiration(validity)
                .claim("role", role)
                .signWith(key)
                .compact();
    }

    public Long getUserId(String token) {
        SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes());
        return Long.parseLong(
                Jwts.parser()
                        .verifyWith(key)
                        .build()
                        .parseSignedClaims(token)
                        .getPayload()
                        .getSubject()
        );
    }

    public String getRoles(String token) {
        SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes());

        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .get("role", String.class);
    }
}

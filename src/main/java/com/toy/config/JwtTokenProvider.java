package com.toy.config;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class JwtTokenProvider {

    private static String jwtSecret;

    @Value("${jwt.secret}")
    public void setJwtSecret(String jwtSecret) {
        this.jwtSecret = jwtSecret;
    }

    private static int jwtExpirationMs;
    @Value("${jwt.expiration}")
    public void setJwtExpirationMs(int jwtExpirationMs) {
        this.jwtExpirationMs = jwtExpirationMs;
    }


    public static String generateToken(String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationMs);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getUsernameFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (ExpiredJwtException e){
            log.info("만료된 JWT 토큰입니다.");
        } catch (UnsupportedJwtException e){
            log.info("지원되지 않는 JWT토큰입니다.");
        }
        return false;
    }
}

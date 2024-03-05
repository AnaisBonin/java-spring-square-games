package fr.campusnumerique.java.cda2025.square_games.security;

import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtTokenProvider {

    private String jws;

    public JwtTokenProvider(String username) {
        generateToken(username, 5);
    }

    public String getJws() {
        return jws;
    }

    public void setJws(String jws) {
        this.jws = jws;
    }

    public String generateToken(String username, int expirationInMinutes) {
        SecretKey key = Jwts.SIG.HS512.key().build();
        Date date = new Date();
        Date expiration = new Date(date.getTime() + 60000L * expirationInMinutes); // 60 000 milliseconds = 1 minute

        this.jws = Jwts.builder()
                .subject(username)
                .signWith(key)
                .issuedAt(date)
                .expiration(expiration)
                .compact();

        return this.jws;
    };
}

package com.MTlovec.SharedOf.security.Impl;

import com.MTlovec.SharedOf.model.Role;
import com.MTlovec.SharedOf.model.User;
import com.MTlovec.SharedOf.security.JwtUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Service
public class JwtUtilsImpl implements JwtUtils {
    @Value("${jwt.secret}")
    private String secretKey;




    @Override
    public String generateToken(User user, Long expirationTimeInSeconds) {
        String role= user.getRole().getRoleName();
        return Jwts.builder()
                .subject(user.getEmail())
                .claim("id", user.getId())
                .claim("role",role)
                .claim("createdAt",new Date())
                .claim("expiresAt", new Date(System.currentTimeMillis() + expirationTimeInSeconds* 1000))
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expirationTimeInSeconds * 1000))
                .signWith(getSignKey())
                .compact();
    }
    private SecretKey getSignKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    }
}

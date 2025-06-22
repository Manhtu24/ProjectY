package com.MTlovec.SharedOf.security;


import com.MTlovec.SharedOf.model.User;

public interface JwtUtils {
    String generateToken(User user, Long expirationTimeInSeconds);
}

package com.MTlovec.SharedOf.service.Impl;

import com.MTlovec.SharedOf.model.User;
import com.MTlovec.SharedOf.repository.UserRepository;
import com.MTlovec.SharedOf.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository
    @Override
    public String generateToken(User user, Long expirationTimeInSeconds) {
        return "";
    }

    @Override
    public User findByEmail(String email) {
        User user=userRepository.findByEmail(email).orElseThrow(()->
                new RuntimeException("Can not find user with email"));
        return user;
    }
}

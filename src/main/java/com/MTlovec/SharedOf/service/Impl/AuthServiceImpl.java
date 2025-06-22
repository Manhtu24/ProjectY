package com.MTlovec.SharedOf.service.Impl;

import com.MTlovec.SharedOf.dto.common.BaseResponse;
import com.MTlovec.SharedOf.dto.request.UserDTO;
import com.MTlovec.SharedOf.dto.response.UserResponseDTO;
import com.MTlovec.SharedOf.model.User;
import com.MTlovec.SharedOf.security.JwtUtils;
import com.MTlovec.SharedOf.service.AuthService;
import com.MTlovec.SharedOf.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    @Value("${jwt.access-token-validity-in-seconds}")
    private Long accessTokenExpiration;

    @Value("${jwt.refresh-token-validity-in-seconds}")
    private Long refreshTokenExpiration;

    @Override
    public BaseResponse<UserResponseDTO> login(UserDTO userDTO) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    userDTO.getEmail(), userDTO.getPassword()
            ));
            User user=userService.findByEmail(userDTO.getEmail());
            String accessToken= jwtUtils.generateToken(user,accessTokenExpiration);
            String refreshToken=jwtUtils.generateToken(user,refreshTokenExpiration);



        } catch (Exception e) {
        }
    }
}

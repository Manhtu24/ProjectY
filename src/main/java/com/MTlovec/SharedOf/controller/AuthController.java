package com.MTlovec.SharedOf.controller;

import com.MTlovec.SharedOf.dto.common.BaseResponse;
import com.MTlovec.SharedOf.dto.request.UserDTO;
import com.MTlovec.SharedOf.dto.response.UserResponseDTO;
import com.MTlovec.SharedOf.model.User;
import com.MTlovec.SharedOf.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authenticationService;


    @PostMapping("/login")
    public ResponseEntity<BaseResponse<UserResponseDTO>> login(@RequestBody UserDTO userDTO){
        return  ResponseEntity.ok(authenticationService.login(userDTO));
    }

    @PostMapping("/register")
    public ResponseEntity<BaseResponse<UserResponseDTO>> register(@RequestBody User user) {
        return null;
    }

    @PostMapping("/logout")
    public ResponseEntity<BaseResponse<String>> logout() {
        return null;
    }

}

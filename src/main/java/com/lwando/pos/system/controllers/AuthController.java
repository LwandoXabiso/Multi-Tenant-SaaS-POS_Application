package com.lwando.pos.system.controllers;

import com.lwando.pos.system.Service.AuthService;
import com.lwando.pos.system.exceptions.UserException;
import com.lwando.pos.system.payload.dto.UserDto;
import com.lwando.pos.system.payload.response.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    // http://localhost:5000/auth/register

    @PostMapping("register")
    public ResponseEntity<AuthResponse> registerHandler(
            @RequestBody UserDto userDto
    ) throws UserException{
        return ResponseEntity.ok(
                authService.register(userDto)
        );
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> loginHandler(
            @RequestBody UserDto userDto
    ) throws UserException{
        return ResponseEntity.ok(
                authService.login(userDto)
        );
    }
}

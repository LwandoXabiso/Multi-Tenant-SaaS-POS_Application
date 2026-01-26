package com.lwando.pos.system.controllers;

import com.lwando.pos.system.Service.AuthService;
import com.lwando.pos.system.exceptions.UserException;
import com.lwando.pos.system.payload.dto.UserDTO;
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
//public class AuthController {
//
//    private final AuthService authService;
//
//    // http://localhost:5000/auth/register
//
//    @PostMapping("register")
//    public ResponseEntity<AuthResponse> registerHandler(
//            @RequestBody UserDTO userDto
//    ) throws UserException{
//        return ResponseEntity.ok(
//                authService.register(UserDTO)
//        );
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<AuthResponse> loginHandler(
//            @RequestBody UserDTO userDto
//    ) throws UserException{
//        return ResponseEntity.ok(
//                authService.login(UserDTO)
//        );
//    }
//}

public class AuthController {

    private final AuthService authService;

    // http://localhost:5000/auth/register


    @PostMapping("/register")
    public ResponseEntity<AuthResponse> signupHandler(@RequestBody UserDTO userDTO) throws UserException {
        return ResponseEntity.ok(authService.register(userDTO));
    }


    // http://localhost:5000/auth/login

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> loginHandler(@RequestBody UserDTO userDTO) throws UserException {
        return ResponseEntity.ok(authService.login(userDTO));
    }

}

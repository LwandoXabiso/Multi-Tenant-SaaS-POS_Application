package com.lwando.pos.system.controllers;

import com.lwando.pos.system.Service.UserService;
import com.lwando.pos.system.exceptions.UserException;
import com.lwando.pos.system.mapper.UserMapper;
import com.lwando.pos.system.modal.User;
import com.lwando.pos.system.payload.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor

//public class UserController {
//
//    private final UserService userService;
//
//    @GetMapping("/profile")
//    public ResponseEntity<UserDto> getUserProfile(
//            @RequestHeader("Authorization") String jwt
//    )throws UserException {
//        User user = userService.getUserFromJwtToken(jwt);
//        return ResponseEntity.ok(UserMapper.toDTO(user));
//    }
//
//    @GetMapping("/profile")
//    public ResponseEntity<UserDto> getUserProfile(Authentication authentication) throws UserException {
//        String email = authentication.getName(); // Spring Security sets this from JWT
//        User user = userService.getUserByEmail(email); // fetch user by email
//        return ResponseEntity.ok(UserMapper.toDTO(user));
//    }
//
//
//    @GetMapping("/{id}")
//    public ResponseEntity<UserDto> getUserById(
//            @RequestHeader("Authorization") String jwt,
//            @PathVariable Long id
//    )throws UserException {
//        User user = userService.getUserById(id);
//        return ResponseEntity.ok(UserMapper.toDTO(user));
//    }
//}

public class UserController {

    private final UserService userService;

    @GetMapping("/profile")
    public ResponseEntity<UserDTO> getUserProfile(
            @RequestHeader("Authorization") String jwt) throws UserException {
        User user = userService.getUserFromJwtToken(jwt);
        return ResponseEntity.ok(UserMapper.toDTO(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Long id) throws UserException {
        User user = userService.getUserById(id);

        if (user == null) {
            throw new UserException("User not found");
        }

        return ResponseEntity.ok(UserMapper.toDTO(user));
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Long id) throws UserException {
//        userService.deleteUser(id);
//        ApiResponse apiResponse = new ApiResponse();
//        apiResponse.setMessage("User deleted successfully");
//
//        return ResponseEntity.ok(apiResponse);
//    }

}

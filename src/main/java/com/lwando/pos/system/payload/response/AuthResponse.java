package com.lwando.pos.system.payload.response;


import com.lwando.pos.system.payload.dto.UserDTO;
import lombok.Data;

@Data
public class AuthResponse {

    private String jwt;
    private String message;
    private UserDTO user;

}

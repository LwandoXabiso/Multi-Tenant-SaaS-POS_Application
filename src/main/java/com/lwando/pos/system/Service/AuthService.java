package com.lwando.pos.system.Service;

import com.lwando.pos.system.exceptions.UserException;
import com.lwando.pos.system.payload.dto.UserDTO;
import com.lwando.pos.system.payload.response.AuthResponse;

public interface AuthService {

    AuthResponse register(UserDTO userDto) throws UserException;
    AuthResponse login(UserDTO userDto) throws UserException;
}

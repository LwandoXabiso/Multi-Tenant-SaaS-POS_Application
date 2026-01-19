package com.lwando.pos.system.Service;

import com.lwando.pos.system.exceptions.UserException;
import com.lwando.pos.system.payload.dto.UserDto;
import com.lwando.pos.system.payload.response.AuthResponse;

public interface AuthService {

    AuthResponse register(UserDto userDto) throws UserException;
    AuthResponse login(UserDto userDto) throws UserException;
}

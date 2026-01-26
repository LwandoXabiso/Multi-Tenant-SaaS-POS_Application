package com.lwando.pos.system.mapper;

import com.lwando.pos.system.modal.User;
import com.lwando.pos.system.payload.dto.UserDTO;

public class UserMapper {


    public static UserDTO toDTO(User savedUser) {
        UserDTO userDto = new UserDTO();
        userDto.setId(savedUser.getId());
        userDto.setFullName(savedUser.getFullName());
        userDto.setEmail(savedUser.getEmail());
        userDto.setRole(savedUser.getRole());
        userDto.setCreatedAt(savedUser.getCreatedAt());
        userDto.setUpdatedAt(savedUser.getUpdatedAt());
        userDto.setLastLogin(savedUser.getLastLogin());
        userDto.setPhone(savedUser.getPhone());


        return userDto;
    }
}

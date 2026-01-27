package com.lwando.pos.system.Service;

import com.lwando.pos.system.exceptions.UserException;
import com.lwando.pos.system.model.User;

import java.util.List;

public interface UserService {

    User getUserFromJwtToken(String token) throws UserException;
    User getCurrentUser() throws UserException;
    User getUserByEmail(String email) throws UserException;
    User getUserById(Long id) throws UserException;

    List<User> getAllUser();
}

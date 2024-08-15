package com.philately.service;

import com.philately.model.dto.AuthenticateUserDto;
import com.philately.model.dto.RegisterUserDto;
import com.philately.model.entity.User;

public interface UserService {

    User getUserById(String id);

    boolean loginUser(AuthenticateUserDto authenticateUserDto);

    void registerUser(RegisterUserDto registerUserDto);

    void logout();
}

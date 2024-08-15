package com.philately.service;

import com.philately.model.dto.AuthenticateUserDto;
import com.philately.model.dto.RegisterUserDto;

public interface UserService {

    boolean loginUser(AuthenticateUserDto authenticateUserDto);

    void registerUser(RegisterUserDto registerUserDto);

    void logout();
}

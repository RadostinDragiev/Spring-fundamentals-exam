package com.philately.service;

import com.philately.model.dto.AuthenticateUserDto;

public interface UserService {

    boolean loginUser(AuthenticateUserDto authenticateUserDto);

    void logout();
}

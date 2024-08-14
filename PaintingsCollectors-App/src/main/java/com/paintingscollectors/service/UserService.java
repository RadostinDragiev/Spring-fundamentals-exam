package com.paintingscollectors.service;

import com.paintingscollectors.model.dto.AuthUserDto;
import com.paintingscollectors.model.dto.LoggedUserDto;
import com.paintingscollectors.model.dto.RegisterUserDto;

public interface UserService {

    LoggedUserDto findUser(AuthUserDto authUserDto);

    boolean registerUser(RegisterUserDto registerUserDto);
}

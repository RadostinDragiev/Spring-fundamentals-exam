package com.paintingscollectors.service;

import com.paintingscollectors.model.dto.AuthUserDto;
import com.paintingscollectors.model.dto.LoggedUserDto;

public interface UserService {

    LoggedUserDto findUser(AuthUserDto authUserDto);
}

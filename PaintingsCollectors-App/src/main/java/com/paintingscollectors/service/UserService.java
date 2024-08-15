package com.paintingscollectors.service;

import com.paintingscollectors.model.dto.AuthUserDto;
import com.paintingscollectors.model.dto.LoggedUserDto;
import com.paintingscollectors.model.dto.RegisterUserDto;
import com.paintingscollectors.model.entity.Painting;
import com.paintingscollectors.model.entity.User;

public interface UserService {

    LoggedUserDto findUser(AuthUserDto authUserDto);

    boolean registerUser(RegisterUserDto registerUserDto);

    User getUserByName(String name);

    void addFavoritePainting(String username, Painting painting);

    void addVotePainting(String username, Painting painting);
}

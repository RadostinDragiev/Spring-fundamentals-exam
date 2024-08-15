package com.philately.service;

import com.philately.model.dto.AuthenticateUserDto;
import com.philately.model.dto.RegisterUserDto;
import com.philately.model.entity.Stamp;
import com.philately.model.entity.User;

import java.util.List;

public interface UserService {

    User getUserById(String id);

    boolean loginUser(AuthenticateUserDto authenticateUserDto);

    void registerUser(RegisterUserDto registerUserDto);

    void addStampToWishList(Stamp stamp);

    void removeFromWishlist(String stampUUID);

    void byAllStamps();

    List<Stamp> getWishlist();

    List<Stamp> getPurchased();

    void logout();
}

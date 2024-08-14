package com.paintingscollectors.service.impl;

import com.paintingscollectors.model.dto.AuthUserDto;
import com.paintingscollectors.model.dto.LoggedUserDto;
import com.paintingscollectors.model.dto.RegisterUserDto;
import com.paintingscollectors.model.entity.User;
import com.paintingscollectors.repository.UserRepository;
import com.paintingscollectors.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public LoggedUserDto findUser(AuthUserDto authUserDto) {
        User user = this.userRepository.findUserByUsernameAndPassword(authUserDto.getUsername(), authUserDto.getPassword())
                .orElse(null);
        return user != null ? this.modelMapper.map(user, LoggedUserDto.class) : null;
    }

    @Override
    public boolean registerUser(RegisterUserDto registerUserDto) {
        User newUser = this.modelMapper.map(registerUserDto, User.class);
        this.userRepository.saveAndFlush(newUser);
        return true;
    }

    @Override
    public User getUserByName(String name) {
        return this.userRepository.findUserByUsername(name);
    }
}

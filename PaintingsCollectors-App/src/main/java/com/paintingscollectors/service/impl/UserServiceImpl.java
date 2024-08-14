package com.paintingscollectors.service.impl;

import com.paintingscollectors.model.dto.AuthUserDto;
import com.paintingscollectors.model.dto.LoggedUserDto;
import com.paintingscollectors.model.entity.User;
import com.paintingscollectors.repository.UserRepository;
import com.paintingscollectors.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public LoggedUserDto findUser(AuthUserDto authUserDto) {
        User user = this.userRepository.findUserByUsernameAndPassword(authUserDto.getUsername(), authUserDto.getPassword())
                .orElse(null);
//                .orElseThrow(EntityNotFoundException::new);
        return user != null ? this.modelMapper.map(user, LoggedUserDto.class) : null;
    }
}

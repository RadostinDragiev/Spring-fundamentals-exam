package com.philately.service.impl;

import com.philately.config.UserSession;
import com.philately.model.dto.AuthenticateUserDto;
import com.philately.model.dto.RegisterUserDto;
import com.philately.model.entity.User;
import com.philately.repository.UserRepository;
import com.philately.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserSession userSession;
    private final ModelMapper modelMapper;

    @Override
    public User getUserById(String id) {
        return this.userRepository.findById(id).orElse(new User());
    }

    @Override
    public boolean loginUser(AuthenticateUserDto authenticateUserDto) {
        Optional<User> user = this.userRepository.findUserByUsernameAndPassword(authenticateUserDto.getUsername(), authenticateUserDto.getPassword());
        if (user.isEmpty()) {
            return false;
        }
        User foundUser = user.get();
        this.userSession.login(foundUser.getUuid(), foundUser.getUsername());
        return true;
    }

    @Override
    public void registerUser(RegisterUserDto registerUserDto) {
        User user = this.modelMapper.map(registerUserDto, User.class);
        this.userRepository.saveAndFlush(user);
    }

    @Override
    public void logout() {
        this.userSession.logout();
    }
}

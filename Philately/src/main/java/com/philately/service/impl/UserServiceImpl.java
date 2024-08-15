package com.philately.service.impl;

import com.philately.config.UserSession;
import com.philately.model.dto.AuthenticateUserDto;
import com.philately.model.dto.RegisterUserDto;
import com.philately.model.entity.Stamp;
import com.philately.model.entity.User;
import com.philately.repository.UserRepository;
import com.philately.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    @Transactional
    public void addStampToWishList(Stamp stamp) {
        User user = getUserById(this.userSession.getId());
        Stream<Stamp> stampStream = user.getWishedStamps()
                .stream()
                .filter(s -> s.getUuid().equals(stamp.getUuid()));
        if (stampStream.findAny().isEmpty()) {
            user.getWishedStamps().add(stamp);
        }
    }

    @Override
    @Transactional
    public void removeFromWishlist(String stampUUID) {
        User user = getUserById(this.userSession.getId());
        Set<Stamp> collect = user.getWishedStamps()
                .stream()
                .filter(s -> s.getUuid().equals(stampUUID)).collect(Collectors.toSet());
        user.getWishedStamps().removeAll(collect);
    }

    @Override
    @Transactional
    public void byAllStamps() {
        User user = getUserById(this.userSession.getId());
        Set<Stamp> wishedStamps = user.getWishedStamps();
        Set<Stamp> purchasedStamps = user.getPurchasedStamps();
        purchasedStamps.addAll(wishedStamps);
        user.setWishedStamps(new HashSet<>());
    }

    @Override
    @Transactional
    public List<Stamp> getWishlist() {
        User user = getUserById(this.userSession.getId());
        return new ArrayList<>(user.getWishedStamps());
    }

    @Override
    @Transactional
    public List<Stamp> getPurchased() {
        User user = getUserById(this.userSession.getId());
        return new ArrayList<>(user.getPurchasedStamps());
    }

    @Override
    @Transactional
    public void logout() {
        User user = getUserById(this.userSession.getId());
        user.setWishedStamps(new HashSet<>());
        this.userSession.logout();
    }
}

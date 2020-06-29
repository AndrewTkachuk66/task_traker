package com.andrew.task.tracker.service.impl;

import com.andrew.task.tracker.domain.UserEntity;
import com.andrew.task.tracker.dto.UserDto;
import com.andrew.task.tracker.mapper.UserMapper;
import com.andrew.task.tracker.repository.UserAccountRepository;
import com.andrew.task.tracker.security.JwtTokenProvider;
import com.andrew.task.tracker.service.LoginService;
import com.andrew.task.tracker.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by Andre on 26.06.2020.
 */
@Service
@AllArgsConstructor
@Slf4j
public class LoginServiceImpl implements LoginService {

    private final UserService userService;
    private final UserMapper userMapper;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public UserDto loginUser(UserDto userDto) {
        String email = userDto.getEmail();
        UserEntity user = userService.findByEmail(email);
        UserEntity newUser = new UserEntity();
        if (user == null) {
            newUser.setEmail(email);
            newUser.setFirstName(userDto.getFirstName());
            newUser.setLastName(userDto.getLastName());
            userService.saveUser(newUser);
            log.info("New user. User with email {} was created", email);
            String token = jwtTokenProvider.createToken(email);
            log.info("Granted token {} ", token);
            return userMapper.toUserDto(newUser);
        }
        return userMapper.toUserDto(user);
    }
}

package com.andrew.task.tracker.service.impl;

import com.andrew.task.tracker.component.UserHelper;
import com.andrew.task.tracker.domain.UserEntity;
import com.andrew.task.tracker.dto.UserDto;
import com.andrew.task.tracker.mapper.UserMapper;
import com.andrew.task.tracker.repository.UserAccountRepository;
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
public class UserServiceImpl implements UserService {

    private UserAccountRepository userAccountRepository;
    private UserHelper userHelper;
    private UserMapper userMapper;

    @Override
    public UserEntity findByEmail(String email) {
        return userAccountRepository.findByEmail(email);
    }

    @Override
    public UserDto getUserById(Long id) {
        UserEntity userEntity = userHelper.getUserById(id);
        log.info("User getUserById(): id={}", id);
        return userMapper.toUserDto(userEntity);

    }

    @Override
    public UserDto saveUser(UserEntity userEntity) {
        userAccountRepository.save(userEntity);
        return userMapper.toUserDto(userEntity);
    }
}

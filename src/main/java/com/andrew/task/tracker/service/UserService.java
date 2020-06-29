package com.andrew.task.tracker.service;

import com.andrew.task.tracker.domain.UserEntity;
import com.andrew.task.tracker.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Andre on 26.06.2020.
 */
public interface UserService {
    UserEntity findByEmail(String email);

    UserDto getUserById(Long userId);

    UserDto saveUser(UserEntity userEntity);

    Page<UserEntity> findAllUsersPages(Pageable pageable);
}


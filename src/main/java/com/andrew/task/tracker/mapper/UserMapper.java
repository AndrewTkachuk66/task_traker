package com.andrew.task.tracker.mapper;

import com.andrew.task.tracker.domain.UserEntity;
import com.andrew.task.tracker.dto.UserDto;

/**
 * Created by Andre on 26.06.2020.
 */
public interface UserMapper {
    UserDto toUserDto(UserEntity userEntity);
}

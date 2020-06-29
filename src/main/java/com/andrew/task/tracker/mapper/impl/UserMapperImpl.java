package com.andrew.task.tracker.mapper.impl;

import com.andrew.task.tracker.domain.UserEntity;
import com.andrew.task.tracker.dto.UserDto;
import com.andrew.task.tracker.mapper.UserMapper;
import org.springframework.stereotype.Component;

/**
 * Created by Andre on 26.06.2020.
 */
@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public UserDto toUserDto(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }
        UserDto userDto = new UserDto();
        userDto.setId(userEntity.getId());
        userDto.setEmail(userEntity.getEmail());
        userDto.setFirstName(userEntity.getFirstName());
        userDto.setLastName(userEntity.getLastName());
        return userDto;
    }
}

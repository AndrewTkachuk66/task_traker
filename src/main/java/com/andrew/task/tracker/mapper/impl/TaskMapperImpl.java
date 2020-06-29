package com.andrew.task.tracker.mapper.impl;

import com.andrew.task.tracker.domain.UserEntity;
import com.andrew.task.tracker.domain.user.task.TaskEntity;
import com.andrew.task.tracker.dto.TaskDto;
import com.andrew.task.tracker.mapper.TaskMapper;
import com.andrew.task.tracker.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Created by Andre on 29.06.2020.
 */
@AllArgsConstructor
@Component
public class TaskMapperImpl implements TaskMapper {
    private UserMapper userMapper;

    @Override
    public TaskDto toTaskDto(TaskEntity taskEntity) {
        if ( taskEntity == null ) {
            return null;
        }
        TaskDto taskDto = new TaskDto();
        taskDto.setId(taskEntity.getId());
        taskDto.setDescription(taskEntity.getDescription());
        taskDto.setTitle(taskEntity.getTitle());
        UserEntity userEntity = taskEntity.getUserEntity();
        taskDto.setUserDto(userMapper.toUserDto(userEntity));
        return taskDto;
    }
}

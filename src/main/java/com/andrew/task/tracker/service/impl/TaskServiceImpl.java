package com.andrew.task.tracker.service.impl;

import com.andrew.task.tracker.domain.UserEntity;
import com.andrew.task.tracker.domain.user.task.TaskEntity;
import com.andrew.task.tracker.dto.TaskDto;
import com.andrew.task.tracker.mapper.TaskMapper;
import com.andrew.task.tracker.repository.TaskRepository;
import com.andrew.task.tracker.repository.UserAccountRepository;
import com.andrew.task.tracker.service.TaskService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by Andre on 29.06.2020.
 */
@Service
@AllArgsConstructor
@Slf4j
public class TaskServiceImpl implements TaskService {

    private UserAccountRepository userAccountRepository;
    private TaskRepository taskRepository;
    private TaskMapper taskMapper;

    @Override
    public TaskDto createTask(TaskDto taskDto, String email) {
        UserEntity userEntity = userAccountRepository.findByEmail(email);
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setTitle(taskDto.getTitle());
        taskEntity.setDescription(taskDto.getDescription());
        taskEntity.setTaskStatus(taskDto.getTaskStatus());
        taskEntity.setUserEntity(userEntity);
        taskRepository.save(taskEntity);
        log.info("Creating task: {}", taskDto);
        return taskMapper.toTaskDto(taskEntity);

    }
}

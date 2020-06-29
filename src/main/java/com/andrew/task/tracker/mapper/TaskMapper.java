package com.andrew.task.tracker.mapper;

import com.andrew.task.tracker.domain.user.task.TaskEntity;
import com.andrew.task.tracker.dto.TaskDto;

/**
 * Created by Andre on 29.06.2020.
 */
public interface TaskMapper {

    TaskDto toTaskDto(TaskEntity taskEntity);
}

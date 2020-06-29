package com.andrew.task.tracker.service;

import com.andrew.task.tracker.dto.TaskDto;

/**
 * Created by Andre on 29.06.2020.
 */
public interface TaskService {
    TaskDto createTask(TaskDto taskDto, String email);
}


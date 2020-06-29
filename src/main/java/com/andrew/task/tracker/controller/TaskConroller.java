package com.andrew.task.tracker.controller;

import com.andrew.task.tracker.dto.TaskDto;
import com.andrew.task.tracker.service.TaskService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Andre on 29.06.2020.
 */
@RestController
@RequestMapping("/api/v1/tasks")
@AllArgsConstructor
@Slf4j
public class TaskConroller {

    private TaskService taskService;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created task"),
            @ApiResponse(code = 400, message = "Invalid data"),
    })
    @ApiOperation(value = "Save task into database",
            response = TaskDto.class)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDto createTask(@RequestBody TaskDto taskDto, Authentication authentication) {
        String email = authentication.getName();
        return taskService.createTask(taskDto, email);
    }
}

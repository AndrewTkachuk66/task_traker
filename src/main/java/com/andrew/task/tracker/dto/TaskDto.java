package com.andrew.task.tracker.dto;

import com.andrew.task.tracker.domain.user.task.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Andre on 29.06.2020.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
    private Long id;
    private String title;
    private String description;
    private TaskStatus taskStatus;
    private UserDto userDto;
}

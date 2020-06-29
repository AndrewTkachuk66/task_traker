package com.andrew.task.tracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Andre on 26.06.2020.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserTokenDto {
    private String email;
    private String token;
}

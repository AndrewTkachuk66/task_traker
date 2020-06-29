package com.andrew.task.tracker.controller;

import com.andrew.task.tracker.domain.UserEntity;
import com.andrew.task.tracker.dto.UserDto;
import com.andrew.task.tracker.service.LoginService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;

/**
 * Created by Andre on 26.06.2020.
 */
@RestController
@PermitAll
@RequestMapping(value = "/api/v1/auth/")
@AllArgsConstructor
public class AuthenticationController {
    private final LoginService loginService;

    @ApiOperation(value = "Start authorization process.")
    @PostMapping("/login")
    public UserDto login(@RequestBody UserDto userDto) {
       return loginService.loginUser(userDto);
    }
}

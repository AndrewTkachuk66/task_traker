package com.andrew.task.tracker.controller;

import com.andrew.task.tracker.domain.UserEntity;
import com.andrew.task.tracker.dto.UserDto;
import com.andrew.task.tracker.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Andre on 26.06.2020.
 */
@RestController
@RequestMapping("/api/v1/account")
@AllArgsConstructor
@Slf4j
public class UserAccountController {

    private UserService userService;

    @ApiOperation(value = "get user by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "get user successfully"),
            @ApiResponse(code = 404, message = "user is not found")

    })
    @GetMapping("/{userId}")
    public UserDto getUser(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @ApiOperation(value = "get all users")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "get page with users successfully"),
            @ApiResponse(code = 404, message = "resource not found")

    })
    @GetMapping("/uses/page")
    public Page<UserEntity> getAllUsers(Pageable pageable){
        return userService.findAllUsersPages(pageable);
    }
}

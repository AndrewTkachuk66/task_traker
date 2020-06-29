package com.andrew.task.tracker.component.impl;

import com.andrew.task.tracker.component.UserHelper;
import com.andrew.task.tracker.domain.UserEntity;
import com.andrew.task.tracker.exception.ResourceNotFoundException;
import com.andrew.task.tracker.repository.UserAccountRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by Andre on 26.06.2020.
 */
@Component
@AllArgsConstructor
@Slf4j
public class UserHelperImpl implements UserHelper {

    private UserAccountRepository userAccountRepository;

    @Override
    public UserEntity getUserById(Long id) {
        return userAccountRepository.findById(id).<RuntimeException>orElseThrow(() -> {
            log.info("User with  id {} does not exist", id);
            throw new ResourceNotFoundException("Cannot find user with id " + id);
        });
    }
}

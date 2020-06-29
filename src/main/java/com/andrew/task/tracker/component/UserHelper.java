package com.andrew.task.tracker.component;

import com.andrew.task.tracker.domain.UserEntity;

/**
 * Created by Andre on 26.06.2020.
 */
public interface UserHelper {
    UserEntity getUserById(Long eventId);
}

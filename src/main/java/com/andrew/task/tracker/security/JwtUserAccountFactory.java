package com.andrew.task.tracker.security;

import com.andrew.task.tracker.domain.UserEntity;
import lombok.NoArgsConstructor;

/**
 * Created by Andre on 26.06.2020.
 */
@NoArgsConstructor
public final class JwtUserAccountFactory {


    public static JwtUserAccount create(UserEntity user) {
        return new JwtUserAccount(
                user.getId(),
                user.getEmail()
        );
    }
}

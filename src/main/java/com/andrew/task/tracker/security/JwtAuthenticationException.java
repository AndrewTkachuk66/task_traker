package com.andrew.task.tracker.security;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by Andre on 26.06.2020.
 */
public class JwtAuthenticationException extends AuthenticationException {
    public JwtAuthenticationException(String msg, Throwable t) {
        super(msg, t);
    }

    public JwtAuthenticationException(String msg) {
        super(msg);
    }
}

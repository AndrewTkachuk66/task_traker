package com.andrew.task.tracker.exception;


import com.andrew.task.tracker.domain.user.AbstractEntity;

/**
 * Created by Andre on 26.06.2020.
 */
public class ResourceNotFoundException extends TaskTrackerException{
    public ResourceNotFoundException() {
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public <T extends AbstractEntity> ResourceNotFoundException(Long id, Class<T> entityClass) {
        super(String.format("Resource %s with id %d was not found", entityClass.getSimpleName(), id));
    }
}

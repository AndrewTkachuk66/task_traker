package com.andrew.task.tracker.exception;

/**
 * Created by Andre on 26.06.2020.
 */
public class TaskTrackerException extends RuntimeException {
    public TaskTrackerException() {
    }

    public TaskTrackerException(String message) {
        super(message);
    }

    public TaskTrackerException(String message, Throwable cause) {
        super(message, cause);
    }

    public TaskTrackerException(Throwable cause) {
        super(cause);
    }

    public TaskTrackerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

package com.andrew.task.tracker.domain.user.task;

/**
 * Created by Andre on 29.06.2020.
 */
public enum TaskStatus {
    VIEW(0),
    IN_PROGRESS(1),
    DONE(2);

    private int id;

    TaskStatus(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}

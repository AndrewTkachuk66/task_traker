package com.andrew.task.tracker.repository;

import com.andrew.task.tracker.domain.UserEntity;
import com.andrew.task.tracker.domain.user.task.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Andre on 29.06.2020.
 */
@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}

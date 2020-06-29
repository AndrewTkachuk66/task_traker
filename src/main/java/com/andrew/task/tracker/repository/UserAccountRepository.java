package com.andrew.task.tracker.repository;

import com.andrew.task.tracker.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Andre on 26.06.2020.
 */
public interface UserAccountRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByEmail(String email);
    //UserEntity findById(Long id);
}

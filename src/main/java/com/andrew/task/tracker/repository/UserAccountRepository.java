package com.andrew.task.tracker.repository;

import com.andrew.task.tracker.domain.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Andre on 26.06.2020.
 */
@Repository
public interface UserAccountRepository extends JpaRepository<UserEntity, Long>, PagingAndSortingRepository<UserEntity, Long> {

    UserEntity findByEmail(String email);

    Page<UserEntity> findAll(Pageable pageable);

}

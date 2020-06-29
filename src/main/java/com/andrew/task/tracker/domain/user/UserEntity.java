package com.andrew.task.tracker.domain;

import com.andrew.task.tracker.domain.user.AbstractEntity;
import lombok.*;

import javax.persistence.*;

/**
 * Created by Andre on 26.06.2020.
 */
@Entity
@Table(name = "users", schema = "task_tracker")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Builder
@Data
public class UserEntity extends AbstractEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

}

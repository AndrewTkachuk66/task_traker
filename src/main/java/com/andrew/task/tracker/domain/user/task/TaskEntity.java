package com.andrew.task.tracker.domain.user.task;

import com.andrew.task.tracker.domain.UserEntity;
import com.andrew.task.tracker.domain.user.AbstractEntity;
import lombok.*;

import javax.persistence.*;

/**
 * Created by Andre on 29.06.2020.
 */
@Entity
@Table(name = "tasks", schema = "task_tracker")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Builder
@Data
public class TaskEntity extends AbstractEntity {
    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private TaskStatus taskStatus ;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

}

package com.example.todoapi.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @SequenceGenerator(name = "task_sequence", sequenceName = "task_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_sequence")
    private Long id;

    @NotNull
    private String name;

    private TaskType taskType;

    @Future
    private LocalDateTime dueDate;

    @NotNull
    @Min(0)
    private Integer estimatedTime;

    @Column(columnDefinition = "boolean default false")
    private boolean isFinished;

    private Integer actualTime;

    private LocalDateTime finishedDate;
}

package com.example.todoapi;

import com.example.todoapi.model.Task;
import com.example.todoapi.model.TaskType;
import com.example.todoapi.service.TaskService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class TodoApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoApiApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(TaskService taskService) {

        return args -> {
            taskService.addAll(List.of(
                    Task.builder()
                            .name("Clean up the kitchen")
                            .estimatedTime(3)
                            .taskType(TaskType.HOME)
                            .dateAdded(LocalDateTime.of(2021, 7, 3, 3, 33, 33))
                            .dueDate(LocalDateTime.of(2021, 8, 7, 3, 33, 33))
                            .build(),
                    Task.builder()
                            .name("Send feedback")
                            .taskType(TaskType.WORK)
                            .estimatedTime(2)
                            .dateAdded(LocalDateTime.of(2021, 7, 4, 3, 33, 33))
                            .dueDate(LocalDateTime.of(2021, 8, 8, 4, 33, 33))
                            .build(),
                    Task.builder()
                            .name("Go on a walk")
                            .estimatedTime(1)
                            .taskType(TaskType.HOME)
                            .dateAdded(LocalDateTime.of(2021, 7, 5, 3, 33, 33))
                            .dueDate(LocalDateTime.of(2021, 8, 9, 3, 33, 33))
                            .build(),
                    Task.builder()
                            .name("Water the flowers")
                            .estimatedTime(1)
                            .taskType(TaskType.HOME)
                            .dateAdded(LocalDateTime.of(2021, 7, 6, 3, 33, 33))
                            .dueDate(LocalDateTime.of(2021, 8, 10, 3, 33, 33))
                            .build()
            ));
        };
    }

}

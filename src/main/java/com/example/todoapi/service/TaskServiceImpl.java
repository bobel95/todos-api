package com.example.todoapi.service;


import com.example.todoapi.model.Task;
import com.example.todoapi.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll(
                Sort.by(Sort.Direction.DESC, "dateAdded")
        );
    }

    @Override
    public Task add(Task task) {
        task.setDateAdded(LocalDateTime.now());
        return taskRepository.save(task);
    }

    @Override
    public List<Task> addAll(List<Task> tasks) {
//        tasks.forEach(t -> t.setDateAdded(LocalDateTime.now()));
        return taskRepository.saveAll(tasks);
    }

    @Override
    public void delete(Long taskId) {
        Task task = taskRepository.getById(taskId);
        if (task.isFinished()) {
            throw new IllegalArgumentException("Can't delete finished tasks");
        }
        taskRepository.delete(task);
    }

    @Override
    public Task complete(Long taskId, Integer actualTime) {
        Task task = taskRepository.getById(taskId);
        task.setActualTime(actualTime);
        task.setFinishedDate(LocalDateTime.now());
        task.setFinished(true);

        return taskRepository.save(task);
    }
}

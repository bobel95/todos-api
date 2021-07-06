package com.example.todoapi.controller;

import com.example.todoapi.model.Task;
import com.example.todoapi.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public List<Task> findAll() {
        return taskService.findAll();
    }

    @PostMapping
    public Task add(@RequestBody @Valid Task task) {
        return taskService.add(task);
    }

    @DeleteMapping("/{taskId}")
    public void delete(@PathVariable("taskId") Long taskId) {
        taskService.delete(taskId);
    }

    @PutMapping("/complete/{taskId}")
    public Task completeTask(@PathVariable("taskId") Long taskId,
                             @RequestParam("time_spent") Integer actualTime) {
        return taskService.complete(taskId, actualTime);
    }
}

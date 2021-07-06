package com.example.todoapi.service;

import com.example.todoapi.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> findAll();
    Task add(Task task);
    List<Task> addAll(List<Task> tasks);
    void delete(Long taskId);
    Task complete(Long taskId, Integer actualTime);
}

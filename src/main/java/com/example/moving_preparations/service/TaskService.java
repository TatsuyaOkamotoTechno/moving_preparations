package com.example.moving_preparations.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.moving_preparations.model.Task;
import com.example.moving_preparations.repository.TaskRepository;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findById(Long id) {
        return taskRepository.findById(id);
    }

    public void create(Task task) {
        taskRepository.insert(task);
    }

    public void update(Task task) {
        taskRepository.update(task);
    }

    public void delete(Long id) {
        taskRepository.delete(id);
    }
}

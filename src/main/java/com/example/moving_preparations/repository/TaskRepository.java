package com.example.moving_preparations.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.moving_preparations.mapper.TaskMapper;
import com.example.moving_preparations.model.Task;

@Repository
public class TaskRepository {

    private final TaskMapper taskMapper;

    public TaskRepository(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    public List<Task> findAll() {
        return taskMapper.findAll();
    }

    public Task findById(Long id) {
        return taskMapper.findById(id);
    }

    public void insert(Task task) {
        taskMapper.insert(task);
    }

    public void update(Task task) {
        taskMapper.update(task);
    }

    public void delete(Long id) {
        taskMapper.delete(id);
    }
}

package com.example.moving_preparations.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.moving_preparations.model.Task;

@Mapper
public interface TaskRepository {
    List<Task> findAll();
    Task findById(@Param("id") Long id);
    void insert(Task task);
    void update(Task task);
    void delete(@Param("id") Long id);
}

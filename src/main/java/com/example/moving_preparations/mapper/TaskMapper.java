package com.example.moving_preparations.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.moving_preparations.model.Task;

@Mapper
public interface TaskMapper {
    
    @Select("SELECT id, name, deadline, status, notes, created_at as createdAt, updated_at as updatedAt FROM TASK ORDER BY id DESC")
    List<Task> findAll();
    
    @Select("SELECT id, name, deadline, status, notes, created_at as createdAt, updated_at as updatedAt FROM TASK WHERE id = #{id}")
    Task findById(@Param("id") Long id);
    
    @Insert("INSERT INTO TASK (name, deadline, status, notes, created_at, updated_at) VALUES (#{name}, #{deadline}, #{status}, #{notes}, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)")
    void insert(Task task);
    
    @Update("UPDATE TASK SET name = #{name}, deadline = #{deadline}, status = #{status}, notes = #{notes}, updated_at = CURRENT_TIMESTAMP WHERE id = #{id}")
    void update(Task task);
    
    @Delete("DELETE FROM TASK WHERE id = #{id}")
    void delete(@Param("id") Long id);
}

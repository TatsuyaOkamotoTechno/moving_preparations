package com.example.moving_preparations.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.moving_preparations.model.Item;

@Mapper
public interface ItemMapper {
    
    @Select("SELECT id, name, category, quantity, action_plan as actionPlan, status, notes, created_at as createdAt, updated_at as updatedAt FROM ITEM ORDER BY id DESC")
    List<Item> findAll();
    
    @Select("SELECT id, name, category, quantity, action_plan as actionPlan, status, notes, created_at as createdAt, updated_at as updatedAt FROM ITEM WHERE id = #{id}")
    Item findById(@Param("id") Long id);
    
    @Insert("INSERT INTO ITEM (name, category, quantity, action_plan, status, notes, created_at, updated_at) VALUES (#{name}, #{category}, #{quantity}, #{actionPlan}, #{status}, #{notes}, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)")
    void insert(Item item);
    
    @Update("UPDATE ITEM SET name = #{name}, category = #{category}, quantity = #{quantity}, action_plan = #{actionPlan}, status = #{status}, notes = #{notes}, updated_at = CURRENT_TIMESTAMP WHERE id = #{id}")
    void update(Item item);
    
    @Delete("DELETE FROM ITEM WHERE id = #{id}")
    void delete(@Param("id") Long id);
}

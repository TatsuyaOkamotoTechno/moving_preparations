package com.example.moving_preparations.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.moving_preparations.mapper.ItemMapper;
import com.example.moving_preparations.model.Item;

@Repository
public class ItemRepository {

    private final ItemMapper itemMapper;

    public ItemRepository(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    public List<Item> findAll() {
        return itemMapper.findAll();
    }

    public Item findById(Long id) {
        return itemMapper.findById(id);
    }

    public void insert(Item item) {
        itemMapper.insert(item);
    }

    public void update(Item item) {
        itemMapper.update(item);
    }

    public void delete(Long id) {
        itemMapper.delete(id);
    }
}

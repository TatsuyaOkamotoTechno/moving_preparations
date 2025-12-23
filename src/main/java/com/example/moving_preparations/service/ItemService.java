package com.example.moving_preparations.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.moving_preparations.model.Item;
import com.example.moving_preparations.repository.ItemRepository;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Optional<Item> findById(Long id) {
        Item item = itemRepository.findById(id);
        return Optional.ofNullable(item);
    }

    public Item save(Item item) {
        if (item.getId() == null) {
            itemRepository.insert(item);
        } else {
            itemRepository.update(item);
        }
        return item;
    }

    public void delete(Long id) {
        itemRepository.delete(id);
    }
}

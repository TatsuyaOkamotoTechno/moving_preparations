package com.example.moving_preparations.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import jakarta.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.example.moving_preparations.model.ActionPlan;
import com.example.moving_preparations.model.Item;
import com.example.moving_preparations.model.Status;

@Service
public class ItemService {
    private final List<Item> items = new ArrayList<>();
    private final AtomicLong idGen = new AtomicLong(1);

    @PostConstruct
    public void init() {
        items.add(new Item(idGen.getAndIncrement(), "冷蔵庫", "家電", 1, ActionPlan.TAKE, Status.NOT_STARTED, "引越先で使用", LocalDateTime.now()));
        items.add(new Item(idGen.getAndIncrement(), "ベッド", "家具", 1, ActionPlan.DISCARD, Status.IN_PROGRESS, "処分予定", LocalDateTime.now()));
        items.add(new Item(idGen.getAndIncrement(), "延長コード", "雑貨", 2, ActionPlan.BUY, Status.NOT_STARTED, "買い足し", LocalDateTime.now()));
    }

    public List<Item> findAll() {
        return new ArrayList<>(items);
    }

    public Optional<Item> findById(Long id) {
        return items.stream().filter(i -> i.getId().equals(id)).findFirst();
    }

    public Item save(Item item) {
        if (item.getId() == null) {
            item.setId(idGen.getAndIncrement());
            item.setUpdatedAt(LocalDateTime.now());
            items.add(item);
            return item;
        }

        Optional<Item> existing = findById(item.getId());
        if (existing.isPresent()) {
            Item e = existing.get();
            e.setName(item.getName());
            e.setCategory(item.getCategory());
            e.setQuantity(item.getQuantity());
            e.setActionPlan(item.getActionPlan());
            e.setStatus(item.getStatus());
            e.setNotes(item.getNotes());
            e.setUpdatedAt(LocalDateTime.now());
            return e;
        } else {
            item.setUpdatedAt(LocalDateTime.now());
            items.add(item);
            return item;
        }
    }

    public void delete(Long id) {
        items.removeIf(i -> i.getId().equals(id));
    }
}

package com.example.moving_preparations.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private Long id;
    private String name;
    private String category;
    private Integer quantity;
    private ActionPlan actionPlan;
    private Status status;
    private String notes;
    private LocalDateTime updatedAt;
}

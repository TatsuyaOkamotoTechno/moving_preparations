package com.example.moving_preparations.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.moving_preparations.model.ActionPlan;
import com.example.moving_preparations.model.Item;
import com.example.moving_preparations.model.Status;
import com.example.moving_preparations.service.ItemService;

@Controller
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/top")
    public String top(Model model) {
        long total = itemService.findAll().size();
        long completed = itemService.findAll().stream().filter(i -> i.getStatus() == Status.COMPLETED).count();
        model.addAttribute("total", total);
        model.addAttribute("completed", completed);
        return "top";
    }

    @GetMapping
    public String list(Model model) {
        List<Item> items = itemService.findAll();
        model.addAttribute("items", items);
        return "items/list";
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("item", new Item());
        model.addAttribute("actionPlans", ActionPlan.values());
        model.addAttribute("statuses", Status.values());
        return "items/form";
    }

    @PostMapping
    public String save(@ModelAttribute Item item) {
        itemService.save(item);
        return "redirect:/items";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Item item = itemService.findById(id).orElse(new Item());
        model.addAttribute("item", item);
        model.addAttribute("actionPlans", ActionPlan.values());
        model.addAttribute("statuses", Status.values());
        return "items/form";
    }
}

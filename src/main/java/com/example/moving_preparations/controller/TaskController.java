package com.example.moving_preparations.controller;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.moving_preparations.model.Status;
import com.example.moving_preparations.model.Task;
import com.example.moving_preparations.service.TaskService;

@Controller
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public String list(Model model) {
        model.addAttribute("tasks", taskService.findAll());
        return "tasks/list";
    }

    @GetMapping("/tasks/new")
    public String newForm(Model model) {
        model.addAttribute("task", new Task());
        model.addAttribute("statuses", Status.values());
        return "tasks/form";
    }

    @PostMapping("/tasks")
    public String create(@ModelAttribute Task task, @RequestParam(required = false) String deadlineStr) {
        if (deadlineStr != null && !deadlineStr.isEmpty()) {
            try {
                task.setDeadline(LocalDate.parse(deadlineStr));
            } catch (DateTimeParseException e) {
            }
        }
        if (task.getStatus() == null) {
            task.setStatus(Status.NOT_STARTED);
        }
        taskService.create(task);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        Task task = taskService.findById(id);
        model.addAttribute("task", task != null ? task : new Task());
        model.addAttribute("statuses", Status.values());
        return "tasks/form";
    }

    @PostMapping("/tasks/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Task task, @RequestParam(required = false) String deadlineStr) {
        task.setId(id);
        if (deadlineStr != null && !deadlineStr.isEmpty()) {
            try {
                task.setDeadline(LocalDate.parse(deadlineStr));
            } catch (DateTimeParseException e) {
            }
        }
        taskService.update(task);
        return "redirect:/tasks";
    }

    @PostMapping("/tasks/{id}/delete")
    public String delete(@PathVariable Long id) {
        taskService.delete(id);
        return "redirect:/tasks";
    }
}

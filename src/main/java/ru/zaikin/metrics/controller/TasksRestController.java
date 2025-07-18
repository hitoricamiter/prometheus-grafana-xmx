package ru.zaikin.metrics.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/tasks")
public class TasksRestController {
    private final List<UUID> tasks = new LinkedList<>();

    @PostMapping
    public ResponseEntity<Void> createTask() {
        this.tasks.add(UUID.randomUUID());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable UUID id) {
        this.tasks.remove(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<UUID>> getTasks() {
        return ResponseEntity.ok(this.tasks);
    }

}

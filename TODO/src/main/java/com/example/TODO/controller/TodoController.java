package com.example.TODO.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

import com.example.TODO.model.Todo;
import com.example.TODO.service.TodoService;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin(origins = "http://localhost:3000") // allow React dev server; change for prod
@Validated
public class TodoController {
    private final TodoService service;
    public TodoController(TodoService s) { this.service = s; }

    @GetMapping
    public List<Todo> getAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getOne(@PathVariable Long id){
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    public static class TodoRequest {
        @NotBlank
        public String title;
        public String description;
        public Boolean completed;
    }

    @PostMapping
    public ResponseEntity<Todo> create(@Valid @RequestBody TodoRequest req){
        Todo t = new Todo(req.title, req.description);
        Todo saved = service.save(t);
        return ResponseEntity.status(201).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> update(@PathVariable Long id, @RequestBody TodoRequest req){
        return service.findById(id).map(existing -> {
            if(req.title != null) existing.setTitle(req.title);
            if(req.description != null) existing.setDescription(req.description);
            if(req.completed != null) existing.setCompleted(req.completed);
            Todo updated = service.save(existing);
            return ResponseEntity.ok(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if(service.findById(id).isPresent()){
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

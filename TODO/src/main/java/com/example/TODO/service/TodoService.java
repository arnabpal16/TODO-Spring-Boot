package com.example.TODO.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.TODO.model.Todo;
import com.example.TODO.repository.TodoRepository;

@Service
public class TodoService {
    private final TodoRepository repo;
    public TodoService(TodoRepository repo) { this.repo = repo; }

    public List<Todo> findAll() { return repo.findAll(); }
    public Optional<Todo> findById(Long id) { return repo.findById(id); }
    public Todo save(Todo t) { return repo.save(t); }
    public void deleteById(Long id) { repo.deleteById(id); }
}
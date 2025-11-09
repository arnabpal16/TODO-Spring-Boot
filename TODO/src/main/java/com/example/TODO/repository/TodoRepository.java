package com.example.TODO.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.TODO.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> { }
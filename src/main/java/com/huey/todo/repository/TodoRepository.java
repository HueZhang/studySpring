package com.huey.todo.repository;

import com.huey.todo.entity.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TodoRepository extends JpaRepository<TodoItem, UUID> {
}

package com.huey.todo.service;

import com.huey.todo.entity.TodoItem;
import com.huey.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class TodoService {

    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }


    //
    public List<TodoItem> getAll() {

        return repository.findAll();
    }

    public TodoItem getById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
    }

    public TodoItem create(TodoItem item) {
        item.setCreatedDate(LocalDateTime.now());
        return repository.save(item);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    public TodoItem update(UUID id, TodoItem updated) {
        TodoItem existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));

        existing.setTitle(updated.getTitle());
        existing.setDescription(updated.getDescription());
        existing.setDueDate(updated.getDueDate());
        existing.setPriority(updated.getPriority());

        return repository.save(existing);
    }


    public TodoItem toggleCompleted(UUID id) {
        TodoItem item = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));

        boolean completed = !item.isCompleted();
        item.setCompleted(completed);
        item.setCompletedDate(completed ? LocalDateTime.now() : null);

        return repository.save(item);
    }

}

package com.huey.todo.service;

import com.huey.todo.entity.TodoItem;
import com.huey.todo.model.TodoCreateDTO;
import com.huey.todo.model.TodoUpdateDTO;
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


    /**
     * 获取全部
     * @return
     */
    public List<TodoItem> getAll() {

        return repository.findAll();
    }

    /**
     * 详情
     * @param id
     * @return
     */
    public TodoItem getById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
    }

    /**
     * 创建
     * @param dto
     * @return
     */
    public TodoItem create(TodoCreateDTO dto) {
        TodoItem item = new TodoItem();
        item.setId(UUID.randomUUID());
        item.setTitle(dto.getTitle());
        item.setDescription(dto.getDescription());
        item.setDueDate(dto.getDueDate());
        item.setPriority(dto.getPriority());
        item.setCompleted(false);
        item.setCreatedDate(LocalDateTime.now());
        return repository.save(item);
    }

    /**
     *
     * @param id
     */
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    /**
     * 更新
     * @param id
     * @param updated
     * @return
     */
    public TodoItem update(UUID id, TodoUpdateDTO updated) {
        TodoItem existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));

        existing.setTitle(updated.getTitle());
        existing.setDescription(updated.getDescription());
        existing.setDueDate(updated.getDueDate());
        existing.setPriority(updated.getPriority());

        return repository.save(existing);
    }

    /**
     * 切换状态
     * @param id
     * @return
     */
    public TodoItem toggleCompleted(UUID id) {
        TodoItem item = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));

        boolean completed = !item.isCompleted();
        item.setCompleted(completed);
        item.setCompletedDate(completed ? LocalDateTime.now() : null);

        return repository.save(item);
    }

}

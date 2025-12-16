package com.huey.todo.controller;

import com.huey.todo.entity.TodoItem;
import com.huey.todo.service.TodoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Todo API", description = "Todo 管理接口")
@RestController
@RequestMapping("/api/todo")
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @Operation(summary = "获取所有 Todo")
    @GetMapping
    public List<TodoItem> getAll() {
        return service.getAll();
    }

    @Operation(summary = "获取单条Todo")
    @GetMapping("/{id}")
    public TodoItem getById(@PathVariable String id) {
        return service.getById(java.util.UUID.fromString(id));
    }
    @Operation(summary = "创建")
    @PostMapping
    public TodoItem create(@RequestBody TodoItem item) {
        return service.create(item);
    }

    @Operation(summary = "删除单条")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(UUID.fromString(id));
    }


    @Operation(summary = "更新 Todo")
    @PutMapping("/{id}")
    public TodoItem update(
            @PathVariable String id,
            @RequestBody TodoItem item) {
        return service.update(UUID.fromString(id), item);
    }

    @Operation(summary = "切换 Todo 完成状态")
    @PatchMapping("/{id}/toggle")
    public TodoItem toggleCompleted(@PathVariable String id) {
        return service.toggleCompleted(UUID.fromString(id));
    }
}

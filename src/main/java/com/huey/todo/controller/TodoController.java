package com.huey.todo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huey.todo.entity.TodoItem;
import com.huey.todo.model.TodoCreateDTO;
import com.huey.todo.model.TodoQueryDTO;
import com.huey.todo.model.TodoUpdateDTO;
import com.huey.todo.service.TodoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Todo API", description = "Todo 管理接口")
@RestController
@RequestMapping("/api/todo")
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @Operation(summary = "分页获取Todo")
    @GetMapping("/page")
    public Page<TodoItem> page(TodoQueryDTO dto) {
        return service.pageQuery(dto);
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
    public void create(@Valid @RequestBody TodoCreateDTO item) {
        service.create(item);
    }

/*    @Operation(summary = "删除单条")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(UUID.fromString(id));
    }*/


    @Operation(summary = "更新 Todo")
    @PutMapping("/{id}")
    public void update(
            @PathVariable String id,
            @RequestBody TodoUpdateDTO item) {
        service.update(id, item);
    }

    @Operation(summary = "切换 Todo 完成状态")
    @PatchMapping("/{id}/toggle")
    public void toggleCompleted(@PathVariable String id) {
        service.toggle(id);
    }
}

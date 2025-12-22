package com.huey.todo.service;

import com.huey.todo.entity.TodoItem;
import com.huey.todo.mapper.TodoMapper;
import com.huey.todo.model.TodoCreateDTO;
import com.huey.todo.model.TodoUpdateDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class TodoService {

    private final TodoMapper mapper;

    public TodoService(TodoMapper mapper) {
        this.mapper = mapper;
    }


    /**
     * 获取全部
     *
     * @return
     */
    public List<TodoItem> getAll() {


        return mapper.selectList(null);
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    public TodoItem getById(UUID id) {
        return mapper.selectById(id);
    }

    public void create(TodoCreateDTO dto) {
        var  e = new TodoItem();
        e.setTitle(dto.getTitle());
        e.setDescription(dto.getDescription());
        e.setPriority(dto.getPriority().ordinal());
        e.setCompleted(false);
        e.setCreatedDate(LocalDateTime.now());
        mapper.insert(e);
    }


    public void update(String id, TodoUpdateDTO dto) {
        var e = mapper.selectById(id);
        if (e == null) {
            throw new RuntimeException("Todo 不存在");
        }
        e.setTitle(dto.getTitle());
        e.setDescription(dto.getDescription());
        e.setPriority(dto.getPriority().ordinal());
        mapper.updateById(e);
    }


    public void toggle(String id) {
        var e = mapper.selectById(id);
        if (e == null) {
            throw new RuntimeException("Todo 不存在");
        }
        boolean completed = !e.getCompleted();
        e.setCompleted(completed);
        e.setCompletedDate(completed ? LocalDateTime.now() : null);
        mapper.updateById(e);
    }

}

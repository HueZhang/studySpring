package com.huey.todo.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@TableName("todo_item")
public class TodoItem {

    @TableId(type = IdType.ASSIGN_UUID)
    private String id;


    private String title;
    private String description;
    private LocalDateTime dueDate;
    private Integer priority;


    private Boolean completed;
    private LocalDateTime createdDate;
    private LocalDateTime completedDate;
}

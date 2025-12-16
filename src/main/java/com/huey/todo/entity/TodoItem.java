package com.huey.todo.entity;


import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity // 告诉jpa需要映射到数据库表的实体
@Table(name = "todo_item")
public class TodoItem {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String title;

    private String description;

    private LocalDateTime dueDate;

    @Enumerated(EnumType.STRING) // 避免枚举顺序变了，数据库全炸
    private EnumTodoPriority priority;

    private boolean Completed;

    private LocalDateTime createdDate;

    private LocalDateTime completedDate;
}

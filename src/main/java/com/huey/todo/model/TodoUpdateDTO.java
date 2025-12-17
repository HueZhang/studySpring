package com.huey.todo.model;

import com.huey.todo.entity.EnumTodoPriority;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TodoUpdateDTO {
    @NotBlank(message = "标题不能为空")
    private String title;


    @Size(max = 200)
    private String description;


    @Future
    private LocalDateTime dueDate;


    @NotNull
    private EnumTodoPriority priority;
}

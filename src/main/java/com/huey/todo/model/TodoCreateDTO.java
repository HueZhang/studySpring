package com.huey.todo.model;

import com.huey.todo.entity.EnumTodoPriority;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TodoCreateDTO {
    @NotBlank(message = "标题不能为空") // ⭐ 高频注解
    private String title;


    @Size(max = 200, message = "描述不能超过200字")
    private String description;


    @Future(message = "截止日期必须是将来时间")
    private LocalDateTime dueDate;


    @NotNull(message = "优先级不能为空")
    private EnumTodoPriority priority;
}

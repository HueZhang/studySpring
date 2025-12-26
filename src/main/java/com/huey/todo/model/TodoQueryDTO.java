package com.huey.todo.model;

import lombok.Data;

@Data
public class TodoQueryDTO {

    private String title;
    private Integer priority;
    private Boolean completed;


    private Integer page = 1; // 默认第一页
    private Integer pageSize = 10; // 默认每页10条
}

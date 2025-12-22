package com.huey.todo.model.Global;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiError {

    private int code; // 业务错误码
    private String message; // 错误信息
    private LocalDateTime time; // 发生时间


    public ApiError(int code, String message) {
        this.code = code;
        this.message = message;
        this.time = LocalDateTime.now();
    }
}

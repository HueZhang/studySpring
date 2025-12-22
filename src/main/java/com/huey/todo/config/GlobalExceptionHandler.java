package com.huey.todo.config;

import com.huey.todo.model.Global.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     1️⃣ @ControllerAdvice 用于统一异常处理
     2️⃣ @Valid 抛出的异常是 MethodArgumentNotValidException
     3️⃣ 业务异常与系统异常要分开处理
     4️⃣ HTTP 状态码和业务错误码要分离
     5️⃣ Controller 层不写 try-catch
     */

    // ⭐ 1. 参数校验失败（@Valid）
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidationException(MethodArgumentNotValidException ex) {
        String msg = ex.getBindingResult()
                .getFieldErrors()
                .get(0)
                .getDefaultMessage();


        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ApiError(40001, msg));
    }

    // ⭐ 2. 业务异常（如：Todo 不存在）
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiError> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ApiError(40401, ex.getMessage()));
    }


    // ⭐ 3. 兜底异常（防止系统炸锅）
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleException(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiError(50000, "系统内部错误"));
    }

}


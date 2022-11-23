package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ResponseManager<T> {
    public ApiResponse<T> success(HttpStatus status, T data) {
        return new ApiResponse<>(status.value(), status, "Request Successful", true, data);
    }

    public ApiResponse<T> error(HttpStatus status, String errorMessage) {
        return new ApiResponse<>(status.value(), status, errorMessage, false, null);
    }
}

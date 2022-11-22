package com.example.demo.pojo;

import lombok.Data;

@Data
public class TaskResponse {
    private String title;
    private String description;
    private String status;
    private String createdAt;
    private String updatedAt;
    private String completedAt;
}

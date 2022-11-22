package com.example.demo.services;

import com.example.demo.dto.TaskDto;
import com.example.demo.pojo.TaskResponse;

public interface TaskServices {
    TaskResponse createTask(String userId, TaskDto taskDto);
    TaskResponse updateTask(String userId, String taskId, TaskDto taskDto);
    TaskResponse getTask(String userid, String taskId);

}

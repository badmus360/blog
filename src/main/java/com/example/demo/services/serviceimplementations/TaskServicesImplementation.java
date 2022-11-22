package com.example.demo.services.serviceimplementations;

import com.example.demo.dto.TaskDto;
import com.example.demo.pojo.TaskResponse;
import com.example.demo.repository.TaskRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.TaskServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TaskServicesImplementation implements TaskServices {

    private final UserRepository userRepository;

    private final TaskRepository taskRepository;

    @Override
    public TaskResponse createTask(String userId, TaskDto taskDto) {

        if(taskDto.getDescription().equals("") || taskDto.getStatus().equals("")){

        }


        return null;
    }

    @Override
    public TaskResponse updateTask(String userId, String taskId, TaskDto taskDto) {
        return null;
    }

    @Override
    public TaskResponse getTask(String userid, String taskId) {
        return null;
    }
}

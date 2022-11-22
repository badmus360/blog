package com.example.demo.controller;

import com.example.demo.dto.LogInDto;
import com.example.demo.dto.UserDto;
import com.example.demo.pojo.ApiResponse;
import com.example.demo.pojo.UserResponse;
import com.example.demo.services.serviceimplementations.UserServicesImplementation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserServicesImplementation userService;

    @PostMapping("/sign-up")
    public ApiResponse<UserResponse> userSignUp(@RequestBody UserDto userDto){
        return userService.signUp(userDto);
    }
    @PostMapping("/sign-in")
    public ApiResponse<UserResponse> userSignIn(@RequestBody LogInDto logInDto){
        return userService.logIn(logInDto);
    }

}

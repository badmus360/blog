package com.example.demo.services;

import com.example.demo.dto.LogInDto;
import com.example.demo.dto.UserDto;
import com.example.demo.pojo.UserResponse;

public interface UserServices {

    UserResponse signUp(UserDto userDto);

    UserResponse logIn(LogInDto logInDto);

}

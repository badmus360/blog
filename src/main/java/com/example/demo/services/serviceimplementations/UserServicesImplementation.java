package com.example.demo.services.serviceimplementations;

import com.example.demo.dto.LogInDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.UserEntity;
import com.example.demo.exceptions.ErrorMessages;
import com.example.demo.exceptions.UserServiceException;
import com.example.demo.pojo.ApiResponse;
import com.example.demo.pojo.ResponseManager;
import com.example.demo.pojo.UserResponse;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.UserServices;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServicesImplementation implements UserServices {

    private final UserRepository userRepository;

    private final ResponseManager responseManager;


    @Override
    public ApiResponse<UserResponse> signUp(UserDto userDto) {
        UserResponse userResponse = new UserResponse();

        UserEntity userEntity = userRepository.findUserByEmailOrPhoneNo(userDto.getEmail(), userDto.getPhoneNo());
            if(userEntity != null){
                throw new UserServiceException(ErrorMessages.RECORD_ALREADY_EXIST.getErrorMessages());
            }

            if(userDto.getFirstName().isEmpty() || userDto.getLastName().isEmpty() ||
            userDto.getEmail().isEmpty() || userDto.getPhoneNo().isEmpty() ||
            userDto.getPassword().isEmpty())
            {
                throw new UserServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessages());
            }

            UserEntity userEntityToSave = new UserEntity();

            BeanUtils.copyProperties(userDto, userEntityToSave);

            UserEntity userEntityCreated = userRepository.save(userEntityToSave);

            BeanUtils.copyProperties(userEntityCreated, userResponse);

            return responseManager.success(HttpStatus.CREATED, userResponse);

    }

    @Override
    public ApiResponse<UserResponse> logIn(LogInDto logInDto) {
        UserResponse userResponse  = new UserResponse();

        UserEntity userEntity = userRepository.findUserByEmailOrPhoneNo(logInDto.getEmail(), logInDto.getPhoneNo());
            if(userEntity == null){
                throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessages());
            }

            if(!userEntity.getPassword().equals(logInDto.getPassword()))
                throw new UserServiceException(ErrorMessages.INCORRECT_LOGIN_DETAILS.getErrorMessages());

        BeanUtils.copyProperties(userEntity, userResponse);

        return responseManager.success(HttpStatus.OK, userResponse);
    }
}

















//    UserResponse userResponse = new UserResponse();
//
//    UserEntity userEntity = userRepository.findUserByEmailOrPhoneNo(userDto.getEmail(), userDto.getPhoneNo());
//        if(userEntity != null)
//                throw new UserServiceException(ErrorMessages.RECORD_ALREADY_EXIST.getErrorMessages());
//
//                if(userDto.getFirstName().isEmpty() || userDto.getLastName().isEmpty() ||
//                userDto.getEmail().isEmpty() || userDto.getPhoneNo().isEmpty() ||
//                userDto.getPassword().isEmpty())
//                {
//                throw new UserServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessages());
//                //return responseManager.error(HttpStatus.BAD_REQUEST, ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessages());
//                }
//
//                UserEntity userEntityToSave = new UserEntity();
//
//                BeanUtils.copyProperties(userDto, userEntityToSave);
//
//                UserEntity userEntityCreated = userRepository.save(userEntityToSave);
//
//                BeanUtils.copyProperties(userEntityCreated, userResponse);
//
//                return responseManager.success(HttpStatus.CREATED, userResponse);
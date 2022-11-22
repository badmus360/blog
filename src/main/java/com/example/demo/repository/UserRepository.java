package com.example.demo.repository;

import com.example.demo.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
//    UserEntity findUserByPhoneNo(String phoneNo);

    UserEntity findUserByEmailOrPhoneNo(String email, String phoneNo);

}

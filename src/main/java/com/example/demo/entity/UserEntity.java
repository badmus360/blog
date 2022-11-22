package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "users")
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String firstName;
    private String lastName;
    private String phoneNo;
    private String email;
    private String password;
    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<TaskEntity> tasks;

}

package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jdk.jfr.Timestamp;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "tasks")
@Getter
@Setter
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String title;
    private String description;
    private String status;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @Timestamp
    private LocalDateTime completedAt;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity users;
}

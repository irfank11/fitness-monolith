package com.project.fitness.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private String id;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

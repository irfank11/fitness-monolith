package com.project.fitness.Service;

import com.project.fitness.Repository.UserRepository;
import com.project.fitness.dtos.LoginRequest;
import com.project.fitness.dtos.RegisterRequest;
import com.project.fitness.dtos.UserResponse;
import com.project.fitness.model.Activity;
import com.project.fitness.model.User;
import com.project.fitness.model.UserRole;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserResponse register(RegisterRequest request) {
        UserRole userRole = request.getRole() != null ? request.getRole() : UserRole.USER;

        User user = User.builder()
                .email(request.getEmail())
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(userRole)
                .build();

//        User user = new User(
//                null,
//                request.getEmail(),
//                request.getPassword(),
//                request.getFirstname(),
//                request.getLastname(),
//                LocalDateTime.now(),
//                LocalDateTime.now(),
//                List.of(),
//                List.of()
//        );
        // this save() method saves the passed entity and returns it.

        User savedUser  = userRepository.save(user);
        return mapToResponse(savedUser);
    }

    public UserResponse mapToResponse(User savedUser) {
        UserResponse response = new UserResponse();
        response.setId(savedUser.getId());
        response.setEmail(savedUser.getEmail());
        response.setPassword(savedUser.getPassword());
        response.setFirstname(savedUser.getFirstname());
        response.setLastname(savedUser.getLastname());
        response.setCreatedAt(savedUser.getCreatedAt());
        response.setUpdatedAt(savedUser.getUpdatedAt());
        return response;
    }

    public User authenticate(LoginRequest request){
        User user = userRepository.findByEmail(request.getEmail());
        if (user == null) throw new RuntimeException("Invalid Credentials");

        if (! passwordEncoder.matches(request.getPassword() , user.getPassword())) throw new RuntimeException("Invalid Credentials");

        return user;
    }


}

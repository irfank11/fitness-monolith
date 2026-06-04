package com.project.fitness.Controller;

import com.project.fitness.Repository.UserRepository;
import com.project.fitness.Security.JwtUtils;
import com.project.fitness.Service.UserService;
import com.project.fitness.dtos.LoginRequest;
import com.project.fitness.dtos.LoginResponse;
import com.project.fitness.dtos.RegisterRequest;
import com.project.fitness.dtos.UserResponse;
import com.project.fitness.model.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
// this creates constructor for only for the final fields (which are initialised as final)
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;
    private final JwtUtils jwtUtils;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@Valid @RequestBody RegisterRequest request){
        return ResponseEntity.ok(userService.register(request));
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){

        System.out.println("LOGIN API HIT");

        try {
            User user = userService.authenticate(loginRequest);
            String token = jwtUtils.generateJwtToken(user.getId(), user.getRole().name());

            return ResponseEntity.ok(
                    new LoginResponse(token, userService.mapToResponse(user))
            );

        } catch (AuthenticationException e) {
            e.printStackTrace();
            return ResponseEntity.status(401).build();
        }
    }

}

package com.example.employeemanagement.controller;

import com.example.employeemanagement.dto.LoginRequestDTO;
import com.example.employeemanagement.dto.LoginResponseDTO;
import com.example.employeemanagement.entity.User;
import com.example.employeemanagement.exception.InvalidCredentialsException;
import com.example.employeemanagement.security.JwtService;
import com.example.employeemanagement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.example.employeemanagement.dto.RegisterRequestDTO;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;


    public AuthController(UserService userService,
                          PasswordEncoder passwordEncoder,
                          JwtService jwtService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public LoginResponseDTO login(@Valid @RequestBody LoginRequestDTO loginRequest) {

        User user = userService.findByUsername(loginRequest.getUsername());

        if (user == null) {
            throw new InvalidCredentialsException(
                    "Invalid username or password"
            );
        }

        if (!passwordEncoder.matches(
                loginRequest.getPassword(),
                user.getPassword())) {

            throw new InvalidCredentialsException(
                    "Invalid username or password"
            );
        }

        String token = jwtService.generateToken(
                user.getUsername(),
                user.getRole()
        );

        return new LoginResponseDTO(token);
    }

    @PostMapping("/register")
    public String register(@Valid @RequestBody RegisterRequestDTO registerRequest) {

        userService.registerUser(
                registerRequest.getUsername(),
                registerRequest.getPassword()
        );

        return "User registered successfully";
    }
}
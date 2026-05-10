package org.example.springlab3notifications.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.springlab3notifications.model.dto.RegisterRequest;
import org.example.springlab3notifications.model.enums.UserRole;
import org.example.springlab3notifications.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    @PostMapping("/register")
    public String register(@RequestBody @Valid RegisterRequest request) {
        authService.register(request, UserRole.ROLE_USER);
        return "Пользователь успешно зарегистрирован";
    }

}
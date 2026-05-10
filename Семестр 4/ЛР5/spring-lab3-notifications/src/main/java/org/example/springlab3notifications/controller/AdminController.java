package org.example.springlab3notifications.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.springlab3notifications.model.dto.RegisterRequest;
import org.example.springlab3notifications.model.enums.UserRole;
import org.example.springlab3notifications.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AuthService authService;

    @GetMapping("/ping")
    public String ping() {
        return "Только для администратора";
    }

    @PostMapping("/register")
    public String register(@RequestBody @Valid RegisterRequest request) {
        authService.register(request, UserRole.ROLE_ADMIN);
        return "Администратор успешно зарегистрирован";
    }
}

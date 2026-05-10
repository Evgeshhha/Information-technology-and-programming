package org.example.springlab3notifications.service;

import lombok.RequiredArgsConstructor;
import org.example.springlab3notifications.model.dto.RegisterRequest;
import org.example.springlab3notifications.model.entity.User;
import org.example.springlab3notifications.model.enums.UserRole;
import org.example.springlab3notifications.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public void register(RegisterRequest request, UserRole userRole) {
        if (userRepository.existsByEmail(
                request.getEmail()
        )) {
            throw new RuntimeException(
                    "Пользователь с таким email уже существует"
            );
        }
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(userRole);
        user.setCreatedAt(LocalDateTime.now());
        userRepository.save(user);
    }
}

package org.example.springlab3notifications.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Map;

public class UserNotFoundException extends AppException {
    public UserNotFoundException(Long userId) {
        super("Пользователь не найден", HttpStatus.NOT_FOUND, Map.of("userId", userId));
    }
}
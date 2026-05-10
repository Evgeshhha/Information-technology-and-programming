package org.example.springlab3notifications.exception;

import org.springframework.http.HttpStatus;

import java.util.Map;

public class NotificationNotFoundException extends AppException {
    public NotificationNotFoundException(Long notificationId) {
        super("Уведомление не найдено", HttpStatus.NOT_FOUND, Map.of("notificationId", notificationId));
    }
}
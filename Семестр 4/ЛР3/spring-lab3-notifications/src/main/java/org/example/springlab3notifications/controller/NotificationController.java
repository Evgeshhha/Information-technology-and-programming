package org.example.springlab3notifications.controller;

import org.example.springlab3notifications.service.EmailService;
import org.example.springlab3notifications.service.NotificationManager;
import org.example.springlab3notifications.service.PushService;
import org.example.springlab3notifications.service.SmsService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {
    private final NotificationManager notificationManager;

    public NotificationController(NotificationManager notificationManager) {
        this.notificationManager = notificationManager;
    }

    @GetMapping("/notify")
    public String notify(@RequestParam String message, @RequestParam String email, @RequestParam String type ) {
        notificationManager.notify(message, email, type);
        return "Уведомление отправлено через Java Config ";
    }
}

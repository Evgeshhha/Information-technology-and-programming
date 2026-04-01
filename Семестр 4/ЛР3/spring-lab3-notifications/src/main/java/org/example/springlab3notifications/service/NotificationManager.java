package org.example.springlab3notifications.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NotificationManager {
    private final Map<String, MessageService> messageService;

    @Autowired
    public NotificationManager(Map<String, MessageService> messageService) {
        this.messageService = messageService;
    }

    public void notify(String message, String recipient, String type) {
        MessageService service = messageService.get(type);

        if (service != null) {
            service.sendMessage(message, recipient);
        } else {
            System.out.println("Сервис не найден: " + type);
        }
        //messageService.forEach(service ->
        //      service.sendMessage(message, recipient));
    }
}

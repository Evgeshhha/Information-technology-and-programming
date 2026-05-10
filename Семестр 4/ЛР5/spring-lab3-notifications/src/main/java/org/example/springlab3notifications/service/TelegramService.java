package org.example.springlab3notifications.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class TelegramService implements MessageService {
    @Override
    public void sendMessage(String message, String recipient) {
        System.out.println("Telegram to" + recipient + ": " + message);
    }
}

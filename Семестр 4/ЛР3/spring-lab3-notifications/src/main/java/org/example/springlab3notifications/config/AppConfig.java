package org.example.springlab3notifications.config;

import org.example.springlab3notifications.service.EmailService;
import org.example.springlab3notifications.service.NotificationManager;
import org.example.springlab3notifications.service.PushService;
import org.example.springlab3notifications.service.SmsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.example.springlab3notifications")
public class AppConfig {

}

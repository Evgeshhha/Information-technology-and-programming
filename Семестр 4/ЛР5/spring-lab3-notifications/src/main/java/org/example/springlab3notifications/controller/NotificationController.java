package org.example.springlab3notifications.controller;

import org.example.springlab3notifications.mapper.NotificationMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.springlab3notifications.model.dto.NotificationDto;
import org.example.springlab3notifications.model.entity.Notification;
import org.example.springlab3notifications.model.enums.NotificationChannel;
import org.example.springlab3notifications.model.enums.NotificationStatus;
import org.example.springlab3notifications.service.NotificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;
    private final NotificationMapper notificationMapper;

    @PostMapping("/add")
    public NotificationDto createNotification(@RequestBody @Valid NotificationDto request) {
        Notification response = notificationService.createNotification(request);

        return notificationMapper.mapToDto(response);
    }

    @GetMapping("/all")
    public List<NotificationDto> getAllNotifications() {
        return notificationMapper.mapToDtoList(
                notificationService.getAllNotifications());
    }

    @GetMapping("/{id}")
    public NotificationDto getNotificationById(@PathVariable Long id) {
        Notification response = notificationService.getNotificationById(id);
        return notificationMapper.mapToDto(response);
    }

    @PutMapping("/{id}")
    public NotificationDto updateNotification(@PathVariable Long id, @RequestBody @Valid NotificationDto request) {
        Notification response = notificationService.updateNotification(id, request);
        return notificationMapper.mapToDto(response);
    }

    @DeleteMapping("/{id}")
    public String deleteNotification(@PathVariable Long id) {
        notificationService.deleteNotification(id);
        return "Уведомление удалено";
    }

    @GetMapping("/status/{status}")
    public List<NotificationDto> getByStatus(@PathVariable NotificationStatus status) {
        return notificationMapper.mapToDtoList(
                notificationService.getNotificationsByStatus(status));
    }

    @GetMapping("/channel/{channel}")
    public List<NotificationDto> getByChannel(@PathVariable NotificationChannel channel) {
        return notificationMapper.mapToDtoList(
                notificationService.getNotificationsByChannel(channel));
    }

    @GetMapping("/recipient/{recipientId}")
    public List<NotificationDto> getByRecipientId(@PathVariable Long recipientId) {
        return notificationMapper.mapToDtoList(
                notificationService.getNotificationsByRecipientId(recipientId));
    }

    @GetMapping("/status/{status}/channel/{channel}")
    public List<NotificationDto> getByStatusAndChannel (@PathVariable NotificationStatus status, @PathVariable NotificationChannel channel) {
        return notificationMapper.mapToDtoList(
                notificationService.getNotificationsByStatusAndChannel(status, channel)
        );
    }
    @GetMapping("/status/{status}/sorted")
    public List<NotificationDto> getByStatusOrderByCreatedAtAsc (@PathVariable NotificationStatus status) {
        return notificationMapper.mapToDtoList(
                notificationService.getNotificationsByStatusOrderByCreatedAtAsc(status)
        );
    }

    @GetMapping("/status/{status}/recipientId/{recipientId}")
    public List<NotificationDto> getByStatusOrderByCreatedAtAsc (@PathVariable NotificationStatus status, @PathVariable Long recipientId) {
        return notificationMapper.mapToDtoList(
                notificationService.getNotificationsByStatusAndRecipientId(status, recipientId)
        );
    }
}

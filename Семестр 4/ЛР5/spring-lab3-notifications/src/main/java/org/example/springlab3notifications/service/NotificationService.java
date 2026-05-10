package org.example.springlab3notifications.service;

import lombok.RequiredArgsConstructor;
import org.example.springlab3notifications.exception.NotificationNotFoundException;
import org.example.springlab3notifications.exception.UserNotFoundException;
import org.example.springlab3notifications.model.dto.NotificationDto;
import org.example.springlab3notifications.model.entity.Notification;
import org.example.springlab3notifications.model.entity.User;
import org.example.springlab3notifications.model.enums.NotificationChannel;
import org.example.springlab3notifications.model.enums.NotificationStatus;
import org.example.springlab3notifications.repository.NotificationRepository;
import org.example.springlab3notifications.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;

    @Transactional
    public Notification createNotification(NotificationDto request) {
        User user = userRepository.findById(request.getRecipientId())
                .orElseThrow(() -> new UserNotFoundException(request.getRecipientId()));
        Notification notification = new Notification();
        notification.setTitle(request.getTitle());
        notification.setMessage(request.getMessage());
        notification.setChannel(request.getChannel());
        notification.setStatus(NotificationStatus.CREATED);
        notification.setCreatedAt(LocalDateTime.now());
        notification.setRecipient(user);
        notificationRepository.save(notification);
        /*if (true) {
            throw new RuntimeException("Искусственная ошибка");
        }*/
        return notification;
    }


    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    public Notification getNotificationById(Long id) {
        return notificationRepository.findById(id)
                .orElseThrow(() -> new NotificationNotFoundException(id));
    }

    public void updateSentAt(Notification notification, NotificationStatus status){
        if(status == NotificationStatus.SENT && notification.getStatus() != NotificationStatus.SENT){
            notification.setSentAt(LocalDateTime.now());
        }
    }

    @Transactional
    public Notification updateNotification(Long id, NotificationDto request) {
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new NotificationNotFoundException(id));
        notification.setTitle(request.getTitle());
        notification.setMessage(request.getMessage());
        notification.setChannel(request.getChannel());
        updateSentAt(notification, request.getStatus());
        notification.setStatus(request.getStatus());
        return notificationRepository.save(notification);
    }

    @Transactional
    public void deleteNotification(Long id) {
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new NotificationNotFoundException(id));
        notificationRepository.delete(notification);
    }

    public List<Notification> getNotificationsByStatus(NotificationStatus status) {
        return notificationRepository.findByStatus(status);
    }

    public List<Notification> getNotificationsByChannel(NotificationChannel channel) {
        return notificationRepository.findByChannel(channel);
    }

    public List<Notification> getNotificationsByRecipientId(Long recipientId) {
        User user = userRepository.findById(recipientId)
                .orElseThrow(() -> new UserNotFoundException(recipientId));
        return notificationRepository.findByRecipientId(recipientId);
    }

    public List<Notification> getNotificationsByStatusAndChannel(NotificationStatus status, NotificationChannel channel) {
        return notificationRepository.findByStatusAndChannel(status, channel);
    }

    public List<Notification> getNotificationsByStatusOrderByCreatedAtAsc(NotificationStatus status) {
        return notificationRepository.findByStatusOrderByCreatedAtAsc(status);
    }

    public List<Notification> getNotificationsByStatusAndRecipientId(NotificationStatus status, Long recipientId) {
        User user = userRepository.findById(recipientId)
                .orElseThrow(() -> new UserNotFoundException(recipientId));
        return notificationRepository.findByStatusAndRecipientId(status, recipientId);
    }

}
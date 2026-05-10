package org.example.springlab3notifications.mapper;

import org.example.springlab3notifications.model.dto.NotificationDto;
import org.example.springlab3notifications.model.entity.Notification;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NotificationMapper {
    public NotificationDto mapToDto(Notification response){
        return NotificationDto.builder()
                .title(response.getTitle())
                .message(response.getMessage())
                .channel(response.getChannel())
                .status(response.getStatus())
                .createdAt(response.getCreatedAt())
                .sentAt(response.getSentAt())
                .recipientId(response.getRecipient()
                        .getId()).build();
    }

    public List<NotificationDto> mapToDtoList(List<Notification> list) {
        return list.stream()
                .map(this::mapToDto)
                .toList();
    }
}

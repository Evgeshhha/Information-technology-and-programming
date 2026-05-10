package org.example.springlab3notifications.mapper;

import org.example.springlab3notifications.model.dto.NotificationDto;
import org.example.springlab3notifications.model.dto.UserDto;
import org.example.springlab3notifications.model.entity.Notification;
import org.example.springlab3notifications.model.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserMapper {
    public UserDto mapToDto(User response){
        return UserDto.builder()
                .name(response.getName())
                .email(response.getEmail())
                .phone(response.getPhone())
                .telegramChatId(response.getTelegramChatId())
                .deviceToken(response.getDeviceToken())
                .createdAt(response.getCreatedAt())
                .build();
    }

    public List<UserDto> mapToDtoList(List<User> list) {
        return list.stream()
                .map(this::mapToDto)
                .toList();
    }
}

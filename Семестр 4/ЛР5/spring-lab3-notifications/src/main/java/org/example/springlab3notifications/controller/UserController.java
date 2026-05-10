package org.example.springlab3notifications.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.springlab3notifications.mapper.UserMapper;
import org.example.springlab3notifications.model.dto.UserDto;
import org.example.springlab3notifications.model.entity.User;
import org.example.springlab3notifications.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/add")
    public UserDto createUser(@RequestBody @Valid UserDto request) {
        User response = userService.createUser(request);
        return userMapper.mapToDto(response);
    }

    @GetMapping("/all")
    public List<UserDto> getAllUsers() {
        return userMapper.mapToDtoList(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        User response = userService.getUserById(id);
        return userMapper.mapToDto(response);
    }

    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable Long id, @RequestBody @Valid
    UserDto request) {
        User response = userService.updateUser(id, request);
        return userMapper.mapToDto(response);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return String.format("Пользователь %s удален", id);
    }
}

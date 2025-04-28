package com.project.stock_management.mapper;

import com.project.stock_management.model.User;
import com.project.stock_management.dto.UserResponseDto;
import java.util.stream.Collectors;

public class UserMapper {
    public static UserResponseDto toDto(User user) {
        return new UserResponseDto(
                user.getId(),
                user.getUsername(),
                user.getRoles().stream()
                        .map(r -> r.getName().name())
                        .collect(Collectors.toSet())
        );
    }
}

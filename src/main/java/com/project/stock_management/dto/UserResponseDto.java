package com.project.stock_management.dto;

import java.util.Set;

public record UserResponseDto(
        Long id,
        String username,
        Set<String> roles
) { }

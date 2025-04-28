package com.project.stock_management.dto;

import jakarta.validation.constraints.*;
import java.util.Set;

public record UpdateUserDto(
        @NotNull Long id,
        @Size(min=8) String password,
        Set<String> roleNames
) { }

package com.project.stock_management.dto;


import jakarta.validation.constraints.*;
import java.util.Set;

public record CreateUserDto(
        @NotBlank String username,
        @NotBlank @Size(min=8) String password,
        @NotEmpty Set<String> roleNames
) { }
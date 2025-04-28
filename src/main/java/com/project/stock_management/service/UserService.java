package com.project.stock_management.service;

import com.project.stock_management.model.User;
import com.project.stock_management.repository.UserRepository;
import com.project.stock_management.dto.*;
import com.project.stock_management.mapper.UserMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepo;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepo,
                       RoleService roleService,
                       PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserResponseDto> listAll() {
        return userRepo.findAll().stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public UserResponseDto create(CreateUserDto dto) {
        User u = User.builder()
                .username(dto.username())
                .passwordHash(passwordEncoder.encode(dto.password()))
                .roles(roleService.getRolesByName(dto.roleNames()))
                .build();
        return UserMapper.toDto(userRepo.save(u));
    }

    @Transactional
    public UserResponseDto update(UpdateUserDto dto) {
        User u = userRepo.findById(dto.id()).orElseThrow();
        if (dto.password() != null) {
            u.setPasswordHash(passwordEncoder.encode(dto.password()));
        }
        if (dto.roleNames() != null) {
            u.setRoles(roleService.getRolesByName(dto.roleNames()));
        }
        return UserMapper.toDto(userRepo.save(u));
    }

    @Transactional
    public void delete(Long id) { userRepo.deleteById(id); }
}


package com.project.stock_management.service;


import com.project.stock_management.model.Role;
import com.project.stock_management.model.RoleName;
import com.project.stock_management.repository.RoleRepository;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.stream.Collectors;

import jakarta.annotation.PostConstruct;

@Service
public class RoleService {
    private final RoleRepository roleRepo;
    public RoleService(RoleRepository roleRepo) { this.roleRepo = roleRepo; }

    /** Ensure roles exist in DB */
    @PostConstruct
    public void initRoles() {
        for (RoleName rn : RoleName.values()) {
            roleRepo.findByName(rn).orElseGet(() ->
                    roleRepo.save(Role.builder().name(rn).build()));
        }
    }

    public Set<Role> getRolesByName(Set<String> names) {
        return names.stream()
                .map(rn -> roleRepo.findByName(RoleName.valueOf(rn))
                        .orElseThrow())
                .collect(Collectors.toSet());
    }
}


package com.project.stock_management.repository;

import com.project.stock_management.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import com.project.stock_management.model.Role;
import com.project.stock_management.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}

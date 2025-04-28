package com.project.stock_management.dto;


import java.util.Set;

public class UserForm {
    private Long id;
    private String username;
    private String password;
    private Set<String> roleNames;

    // Getters and Setters


    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Set<String> getRoleNames() {
        return roleNames;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoleNames(Set<String> roleNames) {
        this.roleNames = roleNames;
    }
}


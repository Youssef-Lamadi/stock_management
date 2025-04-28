package com.project.stock_management.controller;


import com.project.stock_management.dto.*;
import com.project.stock_management.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Controller
@RequestMapping("/users")
public class UserWebController {
    private final UserService userService;

    public UserWebController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userService.listAll());
        return "users/list";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("userForm", new UserForm());
        model.addAttribute("allRoles", Arrays.asList("ROLE_ADMIN", "ROLE_USER"));
        return "users/form";
    }

    @PostMapping("/new")
    public String createUser(@ModelAttribute UserForm userForm) {
        userService.create(new CreateUserDto(
                userForm.getUsername(),
                userForm.getPassword(),
                userForm.getRoleNames()
        ));
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        UserResponseDto user = userService.listAll().stream()
                .filter(u -> u.id().equals(id))
                .findFirst().orElseThrow();
        UserForm form = new UserForm();
        form.setId(user.id());
        form.setUsername(user.username());
        form.setRoleNames(user.roles());
        model.addAttribute("userForm", form);
        model.addAttribute("allRoles", Arrays.asList("ROLE_ADMIN", "ROLE_USER"));
        return "users/form";
    }

    @PostMapping("/edit")
    public String updateUser(@ModelAttribute UserForm userForm) {
        userService.update(new UpdateUserDto(
                userForm.getId(),
                userForm.getPassword(),
                userForm.getRoleNames()
        ));
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}

package com.financeapp.controller;

import com.financeapp.model.User;
import com.financeapp.security.JwtUtil;
import com.financeapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService service;

    // 🔹 Create User (ADMIN only)
    @PostMapping
    public User createUser(@RequestBody User user,
                           @RequestHeader(value = "Authorization", required = false) String authHeader) {

        String role = extractRole(authHeader);

        if (!role.equals("ADMIN")) {
            throw new RuntimeException("Access Denied");
        }

        return service.createUser(user);
    }

    // 🔹 Get All Users (ADMIN only - optional but recommended)
    @GetMapping
    public List<User> getAllUsers(
            @RequestHeader(value = "Authorization", required = false) String authHeader) {

        String role = extractRole(authHeader);

        if (!role.equals("ADMIN")) {
            throw new RuntimeException("Access Denied");
        }

        return service.getAllUsers();
    }

    // 🔐 Common method (REUSABLE)
    private String extractRole(String authHeader) {
        if (authHeader == null) {
            throw new RuntimeException("Access Denied");
        }
        String token = authHeader.replace("Bearer ", "");
        return JwtUtil.extractRole(token);
    }
}
package com.financeapp.controller;

import com.financeapp.security.JwtUtil;
import com.financeapp.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService service;

    // Income
    @GetMapping("/income")
    public double income(@RequestHeader(value = "Authorization", required = false) String authHeader) {
        String role = extractRole(authHeader);

        // ADMIN + ANALYST only
        if (!role.equals("ADMIN") && !role.equals("ANALYST")) {
            throw new RuntimeException("Access Denied");
        }

        return service.income();
    }

    // Expense
    @GetMapping("/expense")
    public double expense(@RequestHeader(value = "Authorization", required = false) String authHeader) {
        String role = extractRole(authHeader);

        if (!role.equals("ADMIN") && !role.equals("ANALYST")) {
            throw new RuntimeException("Access Denied");
        }

        return service.expense();
    }

    // Balance
    @GetMapping("/balance")
    public double balance(@RequestHeader(value = "Authorization", required = false) String authHeader) {
        String role = extractRole(authHeader);

        if (!role.equals("ADMIN") && !role.equals("ANALYST")) {
            throw new RuntimeException("Access Denied");
        }

        return service.balance();
    }

    // Common method
    private String extractRole(String authHeader) {
        if (authHeader == null) {
            throw new RuntimeException("Access Denied");
        }
        String token = authHeader.replace("Bearer ", "");
        return JwtUtil.extractRole(token);
    }
}
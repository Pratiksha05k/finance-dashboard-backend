package com.financeapp.controller;

import com.financeapp.model.FinancialRecord;
import com.financeapp.security.JwtUtil;
import com.financeapp.service.FinancialRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/records")
public class FinancialRecordController {

    @Autowired
    private FinancialRecordService service;

    // Create record (ADMIN only)
    @PostMapping
    public FinancialRecord create(@RequestBody FinancialRecord record,
                                  @RequestHeader(value = "Authorization", required = false) String authHeader) {

        String role = extractRole(authHeader);

        if (!role.equals("ADMIN")) {
            throw new RuntimeException("Access Denied");
        }

        return service.create(record);
    }

    // Get all records (ALL roles)
    @GetMapping
    public List<FinancialRecord> getAll(
            @RequestHeader(value = "Authorization", required = false) String authHeader) {

        extractRole(authHeader); // just validate token

        return service.getAll();
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
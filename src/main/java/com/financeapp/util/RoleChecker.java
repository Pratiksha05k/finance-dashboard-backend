package com.financeapp.util;

import com.financeapp.model.Role;

public class RoleChecker {

    public static void checkAdmin(Role role) {
        if (role != Role.ADMIN) {
            throw new RuntimeException("Access Denied: Admin only");
        }
    }

    public static void checkAnalystOrAdmin(Role role) {
        if (role != Role.ADMIN && role != Role.ANALYST) {
            throw new RuntimeException("Access Denied: Analyst or Admin only");
        }
    }

    public static void checkViewer(Role role) {
        if (role == null) {
            throw new RuntimeException("Invalid role");
        }
    }
}
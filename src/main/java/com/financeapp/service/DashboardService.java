package com.financeapp.service;

import com.financeapp.repository.FinancialRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    @Autowired
    private FinancialRecordRepository repo;

    public double income() {
        return repo.getTotalIncome() != null ? repo.getTotalIncome() : 0;
    }

    public double expense() {
        return repo.getTotalExpense() != null ? repo.getTotalExpense() : 0;
    }

    public double balance() {
        return income() - expense();
    }
}
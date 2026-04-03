package com.financeapp.service;

import com.financeapp.model.*;
import com.financeapp.repository.FinancialRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FinancialRecordService {

    @Autowired
    private FinancialRecordRepository repo;

    public FinancialRecord create(FinancialRecord record) {
        return repo.save(record);
    }

    public List<FinancialRecord> getAll() {
        return repo.findAll();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
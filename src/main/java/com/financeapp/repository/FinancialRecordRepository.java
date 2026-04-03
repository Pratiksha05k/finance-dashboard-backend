package com.financeapp.repository;

import com.financeapp.model.*;
import org.springframework.data.jpa.repository.*;
import java.time.LocalDate;
import java.util.List;

public interface FinancialRecordRepository extends JpaRepository<FinancialRecord, Long> {

    List<FinancialRecord> findByType(RecordType type);
    List<FinancialRecord> findByCategory(String category);
    List<FinancialRecord> findByDateBetween(LocalDate start, LocalDate end);

    @Query("SELECT SUM(f.amount) FROM FinancialRecord f WHERE f.type = 'INCOME'")
    Double getTotalIncome();

    @Query("SELECT SUM(f.amount) FROM FinancialRecord f WHERE f.type = 'EXPENSE'")
    Double getTotalExpense();

    @Query("SELECT f.category, SUM(f.amount) FROM FinancialRecord f GROUP BY f.category")
    List<Object[]> getCategoryWiseTotals();

    @Query("SELECT f FROM FinancialRecord f ORDER BY f.date DESC")
    List<FinancialRecord> getRecentRecords();
}
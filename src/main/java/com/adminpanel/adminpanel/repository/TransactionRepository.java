package com.adminpanel.adminpanel.repository;

import com.adminpanel.adminpanel.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}

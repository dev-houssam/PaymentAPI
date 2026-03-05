package com.repositories;

import com.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}

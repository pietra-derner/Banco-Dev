package com.dev.banking.repository;

import com.dev.banking.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository <Conta, Long> {
}

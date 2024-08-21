package com.dev.banking.dto;

import com.dev.banking.model.Conta;
import com.dev.banking.model.Titular;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosDetalhamentoConta(
        Long id,
        Integer numeroConta,
        Double saldo,
        Titular titular
) {
        public DadosDetalhamentoConta (Conta conta){
                this(conta.getId(), conta.getNumeroConta(), conta.getSaldo(), conta.getTitular());
        }
}

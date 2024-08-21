package com.dev.banking.dto;

import com.dev.banking.model.Titular;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroConta(
        @NotBlank
        Integer numeroConta,

        Double saldo,

        @NotNull
        Titular titular
) {
}

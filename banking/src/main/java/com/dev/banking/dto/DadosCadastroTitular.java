package com.dev.banking.dto;

import com.dev.banking.model.Conta;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroTitular(
        @NotBlank
        String titular,
        @NotBlank @Pattern(regexp = "\\d{11}")
        String cpf,
        @NotBlank @Pattern(regexp = "\\d{11}")
        String telefone,
        @NotBlank @Email
        String email,
        @NotBlank
        String profissao,
        @NotNull
        Conta conta
) {

}

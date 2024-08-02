package com.dev.banking.model;

public record DadosTitular(
        String titular,
        String cpf,
        String telefone,
        String email,
        String profissao,
        String senha) {
}

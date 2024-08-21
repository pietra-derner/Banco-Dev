package com.dev.banking.model;

import com.dev.banking.dto.DadosCadastroTitular;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "titulares")
public class Titular {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titular;
    private String cpf;
    private String telefone;
    private String email;
    private String profissao;
    private String senha;

    @ManyToOne
    private Conta conta;
    public Titular(){}

    public Titular(String titular, DadosCadastroTitular dados){
        this.titular = dados.titular();
        this.cpf = dados.cpf();
        this.telefone = dados.telefone();
        this.email = dados.email();
        this.profissao = dados.profissao();
    }
}

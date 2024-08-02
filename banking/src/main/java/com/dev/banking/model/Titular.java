package com.dev.banking.model;

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
//    @JoinColumn(name = "conta_id")
    private Conta conta;
    public Titular(){}

    public Titular(String titular, DadosTitular dadosTitular){
        this.titular = dadosTitular.titular();
        this.cpf = dadosTitular.cpf();
        this.telefone = dadosTitular.telefone();
        this.email = dadosTitular.email();
        this.profissao = dadosTitular.profissao();
        this.senha = dadosTitular.senha();
    }
}

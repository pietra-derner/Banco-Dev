package com.dev.banking.model;

import com.dev.banking.dto.DadosCadastroConta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "contas")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private int numeroConta;
    private double saldo;

    @OneToMany(mappedBy = "titular", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Titular titular;

    public Conta(int numero, double saldo){
        this.numeroConta = numero;
        this.saldo = saldo;
    }

    public Conta (DadosCadastroConta dados){
        this.numeroConta = dados.numeroConta();
        this.saldo = dados.numeroConta();
    }
}

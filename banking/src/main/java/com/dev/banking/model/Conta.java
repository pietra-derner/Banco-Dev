package com.dev.banking.model;

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
    private int numero;
    private double saldo;

    @OneToMany(mappedBy = "titular", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Titular> titular = new ArrayList<>();

    public Conta(){}

    public Conta (DadosConta dadosConta){
        this.numero = dadosConta.numero();
        this.saldo = dadosConta.saldo();
    }
}

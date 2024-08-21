package com.dev.banking.controller;

import com.dev.banking.dto.DadosCadastroConta;
import com.dev.banking.model.Conta;
import com.dev.banking.repository.ContaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("contas")
public class ControllerConta {

    @Autowired
    private ContaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity criar(@RequestBody @Valid DadosCadastroConta dados, UriComponentsBuilder uriBuilder){
        var conta = new Conta(dados);
        repository.save(conta);

        var uri = uriBuilder.path("/contas/{id}").buildAndExpand(conta.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosCadastroConta(conta));
    }

}

package com.dev.banking.principal;

import com.dev.banking.model.Titular;
import com.dev.banking.repository.ContaRepository;

import java.util.Scanner;

public class Principal {
    Scanner scanner = new Scanner(System.in);
    private final ContaRepository repositorio;

    public Principal(ContaRepository repositorio){
        this.repositorio = repositorio;
    }

    //PRIMEIRO MENU

    public void exibeMenu(){
        int opcao;
        System.out.println("Bem vindo ao Banco Dev!");
        System.out.println("""
                Digite a opção desejada:
                1 - Cadastrar nova conta
                2 - Acessar conta existente
                
                0 - Sair
                """);
        opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao){
            case 1:
                acessaConta();
                break;
            case 2:
                acessaConta();
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    //RESPOSTA AO PRIMEIRO MENU

    public void acessaConta(){
        //inserir nome do titular
        //inserir senha de acesso
    }

    public void cadastraConta(){
        Titular titular = new Titular();

    }

    public void realizaDeposito(){

    }

    public void realizaSaque(){

    }

    public void realizadaTransferencia(){
        //inserir nome do titular da outra conta
        //verifica no banco de dados se o titular existe
    }

    public void visualizaSaldo(){

    }

    public void alteraDadosConta(){

    }

    public void acessaInvestimentos(){

    }


}
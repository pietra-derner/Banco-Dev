package com.dev.banking.principal;

import com.dev.banking.model.Conta;
import com.dev.banking.model.Titular;
import com.dev.banking.repository.ContaRepository;

import java.util.ArrayList;
import java.util.List;
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
                cadastraConta();
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    //RESPOSTA AO PRIMEIRO MENU
    List<Titular> listaTitulares = new ArrayList<>();

    public void cadastraConta(){
        Conta conta = new Conta();
        Titular titular = new Titular();
        System.out.println("Digite o nome do titular:");
        titular.setTitular(scanner.nextLine());
        while (titular.getTitular().length() < 3 && !titular.getTitular().contains(" ")){
            System.out.println("Por favor, digite um nome válido do titular:");
            titular.setTitular(scanner.nextLine());
        }

        System.out.println("Digite o CPF do titular:");
        titular.setCpf(scanner.nextLine());
        System.out.println("Digite o telefone do titular:");
        titular.setTelefone(scanner.nextLine());
        System.out.println("Digite o e-mail do titular:");
        titular.setEmail(scanner.nextLine());
        while (!titular.getEmail().contains("@") && !titular.getEmail().contains(".com")){
            System.out.println("O e-mail não é válido!");
            System.out.println("Digite o e-mail do titular:");
            titular.setEmail(scanner.nextLine());
        }

        System.out.println("Digite a profissão do titular:");
        titular.setProfissao(scanner.nextLine());

        String senha = "";
        while (!senha.equals(titular.getSenha()) && titular.getSenha().length() < 8){
            System.out.println("Digite uma senha de acesso:");
            titular.setSenha(scanner.nextLine());
            System.out.println("Digite novamente a sua senha:");
            senha = scanner.nextLine();
        }

        listaTitulares.add(titular);
        System.out.println("Cadastro realizado com sucesso!");
    }

    public void acessaConta(){
        System.out.println("Insira o nome do titular da conta:");
        var nome = scanner.nextLine();
        for (Titular nomeTitular : listaTitulares){
            if (nomeTitular.getTitular().equalsIgnoreCase(nome)){
                System.out.println("Digite a senha de acesso:");
                var senha = scanner.nextLine();
                if (nomeTitular.getSenha().equalsIgnoreCase(senha)){
                    exibeMenuConta();
                } else {
                    System.out.println("Senha inválida!");
                    return;
                }
            } else {
                System.out.println("Titular inexistente.");
            }
        }
    }

    // MENU DE CONTA CADASTRADA/EXISTENTE

    public void exibeMenuConta(){
        int opcao;
        System.out.println("""
                Digite a opção desejada:
                1 - Realizar depósito
                2 - Realizar saque
                3 - Realizar transferência
                4 - Visualizar saldo
                5 - Área de Investimentos
                                
                9 - Voltar ao menu inicial
                0 - Sair
                """);
        opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao){
            case 1:
                realizaDeposito();
                break;
            case 2:
                realizaSaque();
                break;
            case 3:
                realizaTransferencia();
                break;
            case 4:
                visualizaSaldo();
                break;
            case 5:
                acessaInvestimentos();
                break;
            case 9:
                exibeMenu();
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    public void realizaDeposito(){
        System.out.println("Qual o valor que deseja depositar?");
        var valor = scanner.nextDouble();

    }

    public void realizaSaque(){

    }

    public void realizaTransferencia(){
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
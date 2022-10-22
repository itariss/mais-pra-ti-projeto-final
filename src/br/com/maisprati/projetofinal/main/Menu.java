package br.com.maisprati.projetofinal.main;

import br.com.maisprati.projetofinal.models.Pessoa;

import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        boolean exibirMenu = true;
        String opcao;
        Scanner sc = new Scanner(System.in);

        while(exibirMenu) {
            System.out.println("Digite 1 para começar um cadastro \n" +
                                "Digite 2 para listar as Pessoas Cadastradas \n" +
                                "Digite 3 para listar os Alunos Cadastrados \n" +
                                "Digite 4 para listar todos os cadastros \n" +
                                "Digite 0 para sair");
            
            opcao = String.valueOf(sc.next());
            if (opcao.equals("0")) {
                exibirMenu = false;
                break;
            } else if (!opcao.equals("1")) {
                System.out.println("Valor inválido");
                System.out.println("---------------------");
                continue;
            }

            System.out.println("Informe o nome");
            String nome = sc.next();

            System.out.println("Informe o telefone com DDD (somente números)");
            String telefone = sc.next();

            while (!telefone.matches("\\d{10,11}")) {
                System.out.println("Formato inválido, digite novamente.");
                System.out.println("O número deve ter 10 ou 11 dígitos.");
                telefone = sc.next();
            }

            System.out.println("Informe a data de nascimento");
            String dataNascimento = sc.next();

            while (!dataNascimento.matches("\\d{2}\\/\\d{2}\\/\\d{4}")) {
                System.out.println("Formato inválido, digite novamente.");
                System.out.println("O formato deve seguir o modelo dd/mm/aaaa");
                dataNascimento = sc.next();
            }
        }


    }

}


package br.com.maisprati.projetofinal.main;

import br.com.maisprati.projetofinal.models.Aluno;
import br.com.maisprati.projetofinal.models.Pessoa;

import java.time.LocalDate;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        boolean exibirMenu = true;
        Scanner scanner = new Scanner(System.in);

        String opcao;

        while(exibirMenu) {
            System.out.println("Digite 1 para começar um cadastro \n" +
                                "Digite 2 para listar todos os cadastros \n" +
                                "Digite 3 para atualizar os dados de um cadastro \n" +
                                "Digite 4 para deletar um cadastro \n" +
                                "Digite 0 para sair");

            opcao = String.valueOf(scanner.next());

            switch (opcao) {
                case "0" :
                    exibirMenu = false;
                    System.out.println("Encerrando o programa");
                    break;
                case  "1" :
                   Menu.menuCadastro(scanner);
                    System.out.println("Cadastro realizado com sucesso!");
                   break;
                case "2" :
                    Menu.menuListar();
                    break;
                case "3" :
                    Menu.menuAtualizar(scanner);
                    System.out.println("Cadastro atualizado com sucesso!");
                    break;
                case  "4" :
                    MenuDeletar(scanner);
                    System.out.println("Cadastro deletado com sucesso!");
                    break;
                default:
                    System.out.println("Valor inválido");
                    break;

            }
            System.out.println("----------------------");
        }
        scanner.close();
    }
    public static void menuCadastro(Scanner scanner) {

        System.out.println("Informe o nome");
        String nome = scanner.next();

        System.out.println("Informe o telefone com DDD (somente números)");
        String telefone = scanner.next();
        Menu.validaTelefone(telefone, scanner);

        System.out.println("Informe a data de nascimento");
        String dataNascimento = scanner.next();
        Menu.validaDataNascimento(dataNascimento, scanner);

        System.out.println("Deseja adicionar uma nota final para este cadastro? s/N");

        String temNotaFinal = scanner.next();

        while (!temNotaFinal.matches("s|S|n|N")) {
            System.out.println("Digite s/N para continuar");
            temNotaFinal = scanner.next();
        }

        if (temNotaFinal.equalsIgnoreCase("n")) {
            Pessoa pessoa = new Pessoa(nome, telefone, dataNascimento);
            return;
        }

        System.out.println("Digite a nota final");

        String nota = scanner.next();

        Menu.validaNota(nota, scanner);

        double notaFinal = Double.valueOf(nota.replace(",", "."));

        Aluno aluno = new Aluno(nome, telefone, dataNascimento, notaFinal);

    }
    public static void menuListar() {

        if(Pessoa.listar().isEmpty() && Aluno.listar().isEmpty()) {
            System.out.println("Nenhum cadastro encontrado");
            return;
        }

        Aluno.listar().forEach(a -> System.out.println(a));
    }

    public static  void menuAtualizar(Scanner scanner) {

        Pessoa pessoa = Menu.menuBusca(scanner);

        System.out.println("Digite o nome atualizado, ou digite \"x\" para manter o nome cadastrado");

        String nomeAtualizado = scanner.next();

        if(!nomeAtualizado.matches("x"))
            pessoa.setNome(nomeAtualizado);

        System.out.println("Digite o telefone atualizado, ou digite \"x\" para manter o telefone cadastrado");

        String telefoneAtualizado = scanner.next();

        if(!telefoneAtualizado.matches("x")) {
            Menu.validaTelefone(telefoneAtualizado, scanner);
            pessoa.setTelefone(telefoneAtualizado);
        }

        System.out.println("Digite a data de nascimento atualizada, digite \"x\" para manter a data cadastrada");

        String dataNascimentoAtualizada = scanner.next();
        if(!dataNascimentoAtualizada.matches("x")) {
            pessoa.setDataNascimento(dataNascimentoAtualizada);
            Menu.validaDataNascimento(dataNascimentoAtualizada, scanner);
        }

        if(pessoa.getClass().isInstance(Aluno.class)) {
            Aluno aluno = (Aluno) pessoa;
            System.out.println("Digite a nota atualizada, ou digite \"x\" para manter a nota cadastrada");
            String notaAtualizada = scanner.next();
            if(!notaAtualizada.matches("x")) {
                Menu.validaNota(notaAtualizada, scanner);
                double notaFinal = Double.valueOf(notaAtualizada.replace(",", "."));
                aluno.setNotaFinal(notaFinal);
            }
        }

        pessoa.setDataUltimaAlteracao();

        System.out.println("Cadastro atualizado com sucesso!");

        System.out.println(pessoa);

    }

    public static void MenuDeletar(Scanner scanner) {

        Pessoa pessoa = Menu.menuBusca(scanner);

        Pessoa.deletar(pessoa);
    }

    public static Pessoa menuBusca(Scanner scanner) {
        System.out.println("Para atualizar ou deletar um cadastro, é necessário informar o id do cadastro desejado \n" +
                            "Deseja listar todos os cadastros para encontrar o id? s/N");

        String listarIds = scanner.next();

        while (!listarIds.matches("s|S|n|n")) {
            System.out.println("Digite s/N para continuar");
            listarIds = scanner.next();

        }

        if(listarIds.matches("s|S")) {
            Menu.menuListar();
        }

        System.out.println("Digite o número do id que deseja alterar");

        String valorId = scanner.next();

        while(!valorId.matches("\\d+")) {
            System.out.println("Valor inválido");
        }

        int id = Integer.parseInt(valorId);

        if(Pessoa.buscarPorId(id) == null) {
            System.out.println("Não foi possível encontrar este id");
        } else {
            System.out.println(Pessoa.buscarPorId(id));
        }

        Pessoa pessoa = Pessoa.buscarPorId(id);

        return pessoa;
    }

    public static  void validaTelefone(String telefone, Scanner scanner) {
        while (!telefone.matches("\\d{10,11}")) {
            System.out.println("Formato inválido, digite novamente.");
            System.out.println("O número deve ter 10 ou 11 dígitos.");
            telefone = scanner.next();
        }
    }

    public static void validaDataNascimento(String dataNascimento, Scanner scanner) {
        while (!dataNascimento.matches("\\d{2}\\/\\d{2}\\/\\d{4}")) {
            System.out.println("Formato inválido, digite novamente.");
            System.out.println("O formato deve seguir o modelo dd/mm/aaaa");
            dataNascimento = scanner.next();
        }
    }

    public static void validaNota(String nota, Scanner scanner) {
        while (!nota.matches("\\d\\.?\\,?\\d?")) {
            System.out.println("Formato invalido, digite novamente");
            nota = scanner.next();
        }
    }
}


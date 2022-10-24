package br.com.maisprati.projetofinal.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Pessoa {

    protected String nome;
    protected String telefone;
    protected LocalDate dataNascimento;
    protected LocalDateTime dataCadastro;
    protected LocalDateTime dataUltimaAlteracao;
    protected int id;

    private static final ArrayList<Pessoa> listaPessoas = new ArrayList<>();

    public Pessoa(String nome, String telefone, String dataNascimento) {
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.dataCadastro = LocalDateTime.now();
        this.dataUltimaAlteracao = dataCadastro;
        listaPessoas.add(Pessoa.this);
        this.id = listaPessoas.size();
    }

    public static ArrayList<Pessoa> listar() {
        return listaPessoas;
    }

    public static void deletar(Pessoa pessoa) {
        listaPessoas.remove(pessoa);
    }

    public static Pessoa buscarPorId(int id) {
        return  listaPessoas.stream().filter(p -> p.getId() == id).findFirst().get();

    }

    public int getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public void setDataUltimaAlteracao() {
        this.dataUltimaAlteracao = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "| Pessoa Id: " + id + " | " +
                "Nome: " + nome + " " +
                ", Telefone: " + telefone + " " +
                ", Data de Nascimento: " + dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                ", Data de Cadastro: " + dataCadastro.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm")) +
                ", Data da última alteracao: " + dataUltimaAlteracao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm")) +
                " |";
    }
}

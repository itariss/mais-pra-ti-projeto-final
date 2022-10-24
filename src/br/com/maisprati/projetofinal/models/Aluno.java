package br.com.maisprati.projetofinal.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Aluno extends Pessoa {

    private double notaFinal;

    public Aluno(String nome, String telefone, String dataNascimento, double notaFinal) {
        super(nome, telefone, dataNascimento);
        this.notaFinal = notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

    @Override
    public String toString() {
       return "| Aluno Id: " + id + " | " +
                "Nome: " + nome + " " +
                ", Telefone: " + telefone + " " +
               ", Data de Nascimento: " + dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
               ", Data de Cadastro: " + dataCadastro.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm")) +
               ", Data da última alteracao: " + dataUltimaAlteracao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm"))+
                " |";
    }
}

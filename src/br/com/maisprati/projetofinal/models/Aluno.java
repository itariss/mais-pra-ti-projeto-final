package br.com.maisprati.projetofinal.models;

import java.time.LocalDate;

public class Aluno extends Pessoa {

    private double notaFinal;

    public Aluno(String nome, String telefone, LocalDate dataNascimento, double notaFinal) {
        super(nome, telefone, dataNascimento);
        this.notaFinal = notaFinal;
    }
}

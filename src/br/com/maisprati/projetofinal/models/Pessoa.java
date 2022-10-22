package br.com.maisprati.projetofinal.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Pessoa {

    private String nome;
    private String telefone;
    private LocalDate dataNascimento;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataUltimaAlteracao;

    public Pessoa(String nome, String telefone, String dataNascimento ) {
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.dataCadastro = LocalDateTime.now();
        this.dataUltimaAlteracao = dataCadastro;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", dataNascimento=" + dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                ", dataCadastro=" + dataCadastro.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) +
                ", dataUltimaAlteracao=" + dataUltimaAlteracao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) +
                '}';
    }
}

package br.com.maisprati.projetofinal.models;

import java.time.LocalDate;
import java.time.ZoneId;

public class Pessoa {

    private String nome;
    private String telefone;
    private LocalDate dataNascimento;
    private LocalDate dataCadastro;
    private LocalDate dataUltimaAlteracao;

    public Pessoa(String nome, String telefone, LocalDate dataNascimento ) {
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.dataCadastro = LocalDate.now(ZoneId.of("BET")); // BET - America/Sao_Paulo Time Zone
        this.dataUltimaAlteracao = dataCadastro;
    }

}

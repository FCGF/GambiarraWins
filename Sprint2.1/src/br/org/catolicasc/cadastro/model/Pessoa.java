package br.org.catolicasc.cadastro.model;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public abstract class Pessoa extends Entity {

    private String nome;
    private Date dataNascimento;

    public Pessoa() {
        super();
    }

    public Pessoa(int id) {
        super(id);
    }

    public Pessoa(String nome, Date dataNascimento, int id) {
        this(id);
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public int calculaIdade() {

        Instant instant = Instant.ofEpochMilli(getDataNascimento().getTime());
        LocalDateTime dataNascimento = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        LocalDateTime atual = LocalDateTime.now();
        Period period = Period.between(dataNascimento.toLocalDate(), atual.toLocalDate());
        int anos = period.getYears();

        return anos;
    }

    @Override
    public String toString() {
        return String.format("Pessoa=[ ID: %d, Nome: %s, Data Nascimento: "
                +getDataNascimento().toString()+ " ]",
                getId(), 
                getNome());
    }

}

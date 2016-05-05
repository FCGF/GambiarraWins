package br.org.catolicasc.vendas.model;

import java.util.Calendar;
import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Pessoa extends Entity implements IPessoa {

    private static final Logger LOGGER = LogManager.getLogger(Pessoa.class);

    private String nome;
    private Date dataNascimento;

    public Pessoa() {
        super();

        LOGGER.info("Criando Pessoa pelo construtor padrão.");
    }

    public Pessoa(int id) {
        super(id);

        LOGGER.info("Criando Pessoa pelo construtor padrão.");
    }

    public Pessoa(int id, String nome, Date dataNascimento) {
        super(id);
        this.nome = nome;
        this.dataNascimento = dataNascimento;

        LOGGER.info("Criando " + this);
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public Date getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public int calculaIdade() {
        Calendar nascimento = Calendar.getInstance();
        Calendar atual = Calendar.getInstance();
        nascimento.setTime(getDataNascimento());

        nascimento.set(Calendar.YEAR, atual.get(Calendar.YEAR));

        int idade = nascimento.after(atual) ? -1 : 0;

        nascimento.setTime(getDataNascimento());
        idade += atual.get(Calendar.YEAR) - nascimento.get(Calendar.YEAR);

        return idade;
    }

    @Override
    public String toString() {
        return String.format("%s -> ID: %d; Nome: %s; Data de Nascimento: %tD", this.getClass().getSimpleName(), getId(), getNome(), getDataNascimento());
    }

}

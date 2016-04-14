package br.org.catolicasc.vendas.model;

import br.org.catolicasc.vendas.util.ConversorPeso;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Produto extends Entity implements IProduto {

    private static final Logger LOGGER = LogManager.getLogger(Produto.class);

    private String nome;
    private double peso;
    private double qtdeDisponivel;
    private UnidadePeso unidadePeso;

    public Produto() {
        super();

        LOGGER.info("Criando Produto pelo construtor padrão.");
    }

    public Produto(int id) {
        super(id);
    }

    public Produto(int id, String nome) {
        super(id);
        this.nome = nome;

        LOGGER.info("Criando " + this);
    }

    public Produto(int id, String nome, double peso, double qtdeDisponivel, UnidadePeso unidadePeso) {
        this(id, nome);
        this.peso = peso;
        this.qtdeDisponivel = qtdeDisponivel;
        this.unidadePeso = unidadePeso;
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
    public double getPeso() {
        return peso;
    }

    @Override
    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public double calculaPesoEmQuilo() {
        double pesoQuilo = ConversorPeso.ConverterUnidade(getPeso(), getUnidadePeso(), UnidadePeso.QUILOGRAMA);

        LOGGER.info("Peso em %s do produto %s é %.2f", UnidadePeso.QUILOGRAMA.getSimbolo(), getNome(), pesoQuilo);

        return pesoQuilo;
    }

    @Override
    public double getQtdeDisponivel() {
        return qtdeDisponivel;
    }

    @Override
    public void setQtdeDisponivel(double qtdeDisponivel) {
        this.qtdeDisponivel = qtdeDisponivel;
    }

    @Override
    public UnidadePeso getUnidadePeso() {
        return unidadePeso;
    }

    @Override
    public void setUnidadePeso(UnidadePeso unidadePeso) {
        this.unidadePeso = unidadePeso;
    }

    @Override
    public String toString() {
        return String.format("%s -> ID: %d; Nome: %s; Peso: %.2f; Qtde Disponível: %.2f; Unidade: %s",
                this.getClass().getSimpleName(), getId(), getNome(), getPeso(), getQtdeDisponivel(), getUnidadePeso());
    }
}

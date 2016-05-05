package br.org.catolicasc.vendas.model;

import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Cliente extends Pessoa implements ICliente {

    private static final Logger LOGGER = LogManager.getLogger(Cliente.class);

    private double limiteCredito;
    private int numeroCartaoCredito;
    private String contato;
    private boolean ativo;

    public Cliente() {
        super();

        LOGGER.info("Criando Cliente pelo construtor padrão.");
    }

    public Cliente(int id) {
        super(id);

        LOGGER.info("Criando Cliente pelo construtor padrão.");
    }

    public Cliente(int id, String nome, Date dataNascimento, boolean ativo) {
        super(id, nome, dataNascimento);
        this.ativo = ativo;

        LOGGER.info("Criando " + this);
    }

    @Override
    public double getLimiteCredito() {
        return limiteCredito;
    }

    @Override
    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    @Override
    public int getNumeroCartaoCredito() {
        return numeroCartaoCredito;
    }

    @Override
    public void setNumeroCartaoCredito(int numeroCartaoCredito) {
        this.numeroCartaoCredito = numeroCartaoCredito;
    }

    @Override
    public String getContato() {
        return contato;
    }

    @Override
    public void setContato(String contato) {
        this.contato = contato;
    }

    @Override
    public boolean isAtivo() {
        return ativo;
    }

    @Override
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public boolean verificaCredito(double valorCompra) {

        LOGGER.info(String.format("Verifica Credito, limite: %.2f, valor da compra: %.2f", getLimiteCredito(), valorCompra));

        boolean valido = ((valorCompra > 0.0) && (getLimiteCredito() > valorCompra));

        LOGGER.info("Crédito Válido: " + valido);

        return valido;
    }

    @Override
    public boolean validaCartao() {

        boolean valido = (getNumeroCartaoCredito() > 0);

        LOGGER.info(String.format("Cartão número %s Válido: %b", getNumeroCartaoCredito(), valido));

        return valido;
    }

    @Override
    public String toString() {
        return String.format("%s; Limite: %.2f; Cartão: %d; Ativo: %b", super.toString(), getLimiteCredito(), getNumeroCartaoCredito(), isAtivo());
    }

}

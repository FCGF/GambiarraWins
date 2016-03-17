package br.org.catolicasc.cadastro.model;

import java.util.Date;

/**
 *
 * @author gambiarraWins
 */
public class Cliente extends Pessoa {

    private double limiteCredito;
    private double numeroCartaoCredito;
    private String contato;
    private boolean ativo;

    public Cliente() {
        super();
    }

    public Cliente(int id) {
        super(id);
    }

    public Cliente(int id, String nome, Date dataNascimento, boolean ativo) {
        super(nome, dataNascimento, id);
        this.ativo = ativo;
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public double getNumeroCartaoCredito() {
        return numeroCartaoCredito;
    }

    public String getContato() {
        return contato;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public void setNumeroCartaoCredito(double numeroCartaoCredito) {
        this.numeroCartaoCredito = numeroCartaoCredito;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    public boolean verificaCredito(double valorCompra){
        return (valorCompra <= limiteCredito);
    }
    
    public boolean validaCartao(){
        return (getNumeroCartaoCredito()>0);
    }

    @Override
    public String toString() {
        return String.format("Cliente=[ ID: %d, Nome: %s, Ativo: %b, "
                + "LimiteCredito: %f, Numero Cartao Credito: %f, Contato: %s ]",
                getId(), 
                getNome(), 
                ativo, 
                getLimiteCredito(),
                getNumeroCartaoCredito(),
                getContato()
        );
    }

}

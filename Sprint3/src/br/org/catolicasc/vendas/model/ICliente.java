package br.org.catolicasc.vendas.model;

/**
 *
 * @author flavio.kannenberg
 */
public interface ICliente extends IPessoa {

    String getContato();

    double getLimiteCredito();

    int getNumeroCartaoCredito();

    boolean isAtivo();

    void setAtivo(boolean ativo);

    void setContato(String contato);

    void setLimiteCredito(double limiteCredito);

    void setNumeroCartaoCredito(int numeroCartaoCredito);

    boolean validaCartao();

    boolean verificaCredito(double valorCompra);

}

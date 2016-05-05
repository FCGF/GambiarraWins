package br.org.catolicasc.vendas.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ItemPedido extends Entity {

    private static final Logger LOGGER = LogManager.getLogger(ItemPedido.class);

    private int quantidade;
    private double preco;
    private Produto produto;
    private Pedido pedido;

    public ItemPedido() {
        super();

        LOGGER.info("Criando Item de Pedido pelo construtor padrão.");
    }

    public ItemPedido(int id, int quantidade, double preco, Produto produto, Pedido pedido) {
        super(id);
        this.quantidade = quantidade;
        this.preco = preco;
        this.produto = produto;
        this.pedido = pedido;

        LOGGER.info("Criando " + this);
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double calcularPesoEmQuilo() {

        if (getProduto() == null) {
            String mensagem = "O produto não foi informado";
            LOGGER.error(mensagem);
            throw new NullPointerException(mensagem);
        }

        double pesoProdutoQuilo = getProduto().calculaPesoEmQuilo();
        double pesoQuilo = (getQuantidade() * pesoProdutoQuilo);

        LOGGER.info(String.format("calcularPesoEmQuilo - Quantidade: %d, Peso do Produto: %.2f, Peso Item: %.2f", getQuantidade(), pesoProdutoQuilo, pesoQuilo));

        return pesoQuilo;
    }

    @Override
    public String toString() {
        return String.format("%s -> ID = %d; Produto = %s; Qtde = %d; Preço = %.2f", getClass().getSimpleName(), getId(), getProduto(), getQuantidade(), getPreco());
    }

}

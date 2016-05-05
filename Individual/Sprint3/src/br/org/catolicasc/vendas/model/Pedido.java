package br.org.catolicasc.vendas.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Pedido extends Entity {

    private static final Logger LOGGER = LogManager.getLogger(Pedido.class);

    private Date data;
    private String vendedor;
    private String observacao;
    private Cliente cliente;
    private List<ItemPedido> itens;
    private StatusPedido statusPedido;

    public Pedido() {
        super();
        itens = new ArrayList<>();

        LOGGER.info("Criando Pedido pelo construtor padrão.");
    }

    public Pedido(int id) {
        super(id);

        LOGGER.info("1. Criando " + this);
    }

    public Pedido(int id, Date data) {
        this(id);
        this.data = data;

        LOGGER.info("2. Criando " + this);
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    public double calcularPreco() {
        double preco = 0.0;
        for (ItemPedido item : getItens()) {
            preco += item.getPreco();
        }
        return preco;
    }

    public double calcularPeso() {
        double pesoTotal = 0.0;
        for (ItemPedido item : getItens()) {
            pesoTotal += item.calcularPesoEmQuilo();
        }
        return pesoTotal;
    }

}

package br.org.catolicasc.cadastro.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 *
 * @author GambiarraWins
 */
public class Pedido extends Entity {

    private String vendedor;
    private String observacao;
    Cliente cliente;
    private Date data;
    List<ItemPedido> itens;
    StatusPedido statusPedido;

    public Pedido() {
        super();
        itens = new ArrayList<>();
    }

    public Pedido(int id) {
        super(id);
        itens = new ArrayList<>();
    }

    public Pedido(Date data, int id) {
        super(id);
        this.data = data;
        itens = new ArrayList<>();
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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
        double precoTotal = 0;
        for (ItemPedido item : itens) {
            precoTotal += item.getPreco() * item.getQuantidade();
        }
        return precoTotal;

    }

    public double calcularPeso() {
        double pesoTotal = 0;
        for (ItemPedido item : itens) {
            pesoTotal += item.getProduto().calculaPesoEmQuilo() * item.getQuantidade();
        }
        return pesoTotal;
    }

}

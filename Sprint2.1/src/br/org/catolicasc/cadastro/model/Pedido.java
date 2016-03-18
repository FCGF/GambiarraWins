/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.cadastro.model;

import java.util.List;
import java.util.Date;

/**
 *
 * @author Cyber
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
    }

    public Pedido(int id) {
        super(id);
    }

    public Pedido(Date data, int id) {
        super(id);
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
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
            pesoTotal += item.getProduto().getPeso() * item.getQuantidade();
        }
        return pesoTotal;
    }

}
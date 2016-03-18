/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.cadastro.model;

/**
 *
 * @author Cyber
 */
public class ItemPedido extends Entity{
    
    private int quantidade;
    private double preco;
    Produto produto;

    public ItemPedido() {
        super();
    }

    public ItemPedido(int quantidade, double preco, Produto produto, int id) {
        super(id);
        this.quantidade = quantidade;
        this.preco = preco;
        this.produto = produto;
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

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public double calcularPesoEmQuilo(){
        return produto.calculaPesoEmQuilo();
    }

    @Override
    public String toString() {
        return String.format("IItemPedido=[ ID: %d, Quantidade: %d, Preço: %.2f, Produto: %s]",
                getId(), getQuantidade(), getPreco(), getProduto().toString());
    }
    
    

   

    

    
    
    
    
    
    
    
    
}

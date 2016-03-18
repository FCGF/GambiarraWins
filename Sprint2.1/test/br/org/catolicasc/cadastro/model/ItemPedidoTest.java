/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.cadastro.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rafael.chewinski
 */
public class ItemPedidoTest {
    
    private ItemPedido itemPedido = null;
    
    public ItemPedidoTest() {
    }
    
    @Before
    public void setUp() {
        itemPedido = new ItemPedido();
    }
    
    @After
    public void tearDown() {
        itemPedido = null;
    }

    @Test
    public void testSetQuantidade() {
        int atual = 50;
        itemPedido.setQuantidade(atual);
        int quantidade = itemPedido.getQuantidade();
        assertEquals(quantidade, atual, 0);
    }

    @Test
    public void testSetPreco() {
        double atual = 10;
        itemPedido.setPreco(atual);
        double preco = itemPedido.getPreco();
        assertEquals(preco, atual, 0);
    }

    @Test
    public void testSetProduto() {
        Produto atual = new Produto(1, "teste");
        itemPedido.setProduto(atual);
        Produto resultado = itemPedido.getProduto();
        assertEquals(atual.getId(), resultado.getId());
        assertEquals(atual.getNome(), resultado.getNome());
    }

    @Test
    public void testCalcularPesoEmQuilo() {
        Produto atual = new Produto();
        int gramas = 1000;
        atual.setPeso(gramas);
        atual.setUnidade(UnidadePeso.GRAMA);
        double peso = atual.calculaPesoEmQuilo();
        assertEquals(peso, gramas/1000, 0);
    }

    @Test
    public void testToString() {
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.cadastro.model;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author rafael.chewinski
 */
public class ProdutoTest {
    
    private Produto produto = null;
    
    public ProdutoTest() {
    }

    @Before
    public void setUp() throws Exception {
        produto = new Produto();
    }

    @After
    public void tearDown() throws Exception {
        produto = null;
    }

    @Test
    public void testSetNome() {
        String atual = "teste";
        produto.setNome(atual);
        String nome = produto.getNome();       
        assertEquals(nome, atual);
    }

    @Test
    public void testSetPeso() {
        double atual = 80;
        produto.setPeso(atual);
        double peso = produto.getPeso();       
        assertEquals(peso, atual, 0);
    }

    @Test
    public void testSetQtdeDisponivel() {
        double atual = 50;
        produto.setQtdeDisponivel(atual);
        double quantidade = produto.getQtdeDisponivel();       
        assertEquals(quantidade, atual, 0);
    }

    @Test
    public void testSetUnidade_UnidadePeso() {
        UnidadePeso atual = UnidadePeso.GRAMA;
        produto.setUnidade(atual);
        UnidadePeso unidade = produto.getUnidade();       
        assertEquals(unidade, atual);
    }

    @Test
    public void testSetUnidade_int() {
        int atual = 1;
        produto.setUnidade(atual);
        UnidadePeso unidade = produto.getUnidade();       
        assertEquals(unidade, UnidadePeso.GRAMA);
    }

    @Test
    public void testCalculaPesoEmQuilo() {
        int gramas = 1000;
        produto.setPeso(gramas);
        produto.setUnidade(UnidadePeso.GRAMA);
        double peso = produto.calculaPesoEmQuilo();
        assertEquals(peso, gramas/1000, 0);
    }

    @Test
    public void testToString() {
         assertTrue(produto.toString() != null && !produto.toString().isEmpty());
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.data;

import br.org.catolicasc.model.Categoria;
import br.org.catolicasc.model.Produto;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ProdutoJDBCTest {
    
    private static ProdutoJDBC produtoJdbc;
    
    public ProdutoJDBCTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        produtoJdbc = new ProdutoJDBC();
    }

    @Test
    public void testFindAll() throws Exception {
        List<Produto> actual = produtoJdbc.findAll();
        assertTrue(actual.size() > 0);
    }

    @Test
    public void testFind() throws ClassNotFoundException, Exception {
        final int CUSTOMER_ID = 1;
        Produto actual = produtoJdbc.find(CUSTOMER_ID);
        assertNotNull(actual);
        assertEquals(CUSTOMER_ID, actual.getId());

    }

    @Test
    public void testCreate() throws ClassNotFoundException, Exception {
        Categoria categoria = new Categoria();
        Produto produto = new Produto(0, categoria, "teste", 0, 0, 0, true);
        
        produto = produtoJdbc.create(produto);
        
        assertNotNull(produto);
        assertTrue(produto.getId() != 0);

        Produto produtoPersistente = produtoJdbc.find(produto.getId());

        assertEquals(produto.getId(), produtoPersistente.getId());
        assertEquals(produto.getNome(), produtoPersistente.getNome());
        assertEquals(produto.getCategoria(), produtoPersistente.getCategoria());
        assertEquals(produto.getPreco_unitario(), produtoPersistente.getPreco_unitario());
        assertEquals(produto.getEstoque(), produtoPersistente.getEstoque());
        assertEquals(produto.getQuantidade(), produtoPersistente.getQuantidade());
        assertEquals(produto.isDescontinuado(), produtoPersistente.isDescontinuado());
    }

    @Test
    public void testUpdate() throws ClassNotFoundException, Exception {
        Categoria categoria = new Categoria();
        Produto produto = new Produto(0, categoria, "teste", 0, 0, 0, true);
        produtoJdbc.create(produto);
        assertNotNull(produto);
        assertTrue(produto.getId() != 0);

        Produto produtoPersistente = produtoJdbc.find(produto.getId());
        
        assertNotNull(produtoPersistente);
        assertEquals(produto.getId(), produtoPersistente.getId());
        assertEquals(produto.getNome(), produtoPersistente.getNome());
        assertEquals(produto.getCategoria(), produtoPersistente.getCategoria());
        assertEquals(produto.getPreco_unitario(), produtoPersistente.getPreco_unitario());
        assertEquals(produto.getEstoque(), produtoPersistente.getEstoque());
        assertEquals(produto.getQuantidade(), produtoPersistente.getQuantidade());
        assertEquals(produto.isDescontinuado(), produtoPersistente.isDescontinuado());
        
        produto.setNome("Produto Modificado.");
        produto.setDescontinuado(false);
        
        produtoJdbc.update((produto));
        
        produtoPersistente = produtoJdbc.find(produto.getId());
        
        assertNotNull(produtoPersistente);
        assertEquals(produto.getId(), produtoPersistente.getId());
        assertEquals(produto.getNome(), produtoPersistente.getNome());
        assertEquals(produto.getCategoria(), produtoPersistente.getCategoria());
        assertEquals(produto.getPreco_unitario(), produtoPersistente.getPreco_unitario());
        assertEquals(produto.getEstoque(), produtoPersistente.getEstoque());
        assertEquals(produto.getQuantidade(), produtoPersistente.getQuantidade());
        assertEquals(produto.isDescontinuado(), produtoPersistente.isDescontinuado());
    }

    @Test
    public void testDelete() throws ClassNotFoundException, Exception {
        Categoria categoria = new Categoria();
        Produto produto = new Produto(0, categoria, "teste", 0, 0, 0, true);
        
        produtoJdbc.create(produto);
        
        assertNotNull(produto);
        assertTrue(produto.getId() != 0);
        
        produtoJdbc.delete(produto.getId());
        
        Produto produtoPersistente = produtoJdbc.find(produto.getId());
          
        assertNull(produtoPersistente);
    }

    @Test
    public void testDeleteAll() {
    }

    @Test
    public void testCount() {
    }
    
}

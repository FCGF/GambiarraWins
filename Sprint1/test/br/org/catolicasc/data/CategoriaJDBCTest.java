/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.data;

import br.org.catolicasc.model.Categoria;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CategoriaJDBCTest {
    
    private static CategoriaJDBC categoriaJdbc;
    
    public CategoriaJDBCTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        categoriaJdbc = new CategoriaJDBC();
    }

    @Test
     public void testFindAll() throws Exception {
        List<Categoria> actual = categoriaJdbc.findAll();
        assertTrue(actual.size() > 0);
    }

    @Test
    public void testFind() throws ClassNotFoundException, Exception {
        final int CUSTOMER_ID = 1;
        Categoria actual = categoriaJdbc.find(CUSTOMER_ID);
        assertNotNull(actual);
        assertEquals(CUSTOMER_ID, actual.getId());
    }

    @Test
    public void testCreate() throws ClassNotFoundException, Exception {
        Categoria categoria = new Categoria(0, "s", "desc");
        
        categoria = categoriaJdbc.create(categoria);
        
        assertNotNull(categoria);
        assertTrue(categoria.getId() != 0);

        Categoria categoriaPersistente = categoriaJdbc.find(categoria.getId());

        assertEquals(categoria.getId(), categoriaPersistente.getId());
        assertEquals(categoria.getNome(), categoriaPersistente.getNome());
        assertEquals(categoria.getDescricao(), categoriaPersistente.getDescricao());
    }

    @Test
    public void testUpdate() throws ClassNotFoundException, Exception {
        Categoria categoria = new Categoria(0, "Teste Cliente", "Teste Descrição");
        categoriaJdbc.create(categoria);
        assertNotNull(categoria);
        assertTrue(categoria.getId() != 0);

        Categoria categoriaPersistente = categoriaJdbc.find(categoria.getId());
        
        assertNotNull(categoriaPersistente);
        assertEquals(categoria.getId(), categoriaPersistente.getId());
        assertEquals(categoria.getNome(), categoriaPersistente.getNome());
        assertEquals(categoria.getDescricao(), categoriaPersistente.getDescricao());
        
        categoria.setNome("Cliente Modificado.");
        categoria.setDescricao("Descrição Modificada");
        
        categoriaJdbc.update((categoria));
        
        categoriaPersistente = categoriaJdbc.find(categoria.getId());
        
        assertNotNull(categoriaPersistente);
        assertEquals(categoria.getId(), categoriaPersistente.getId());
        assertEquals(categoria.getNome(), categoriaPersistente.getNome());
        assertEquals(categoria.getDescricao(), categoriaPersistente.getDescricao());
    }

    @Test
    public void testDelete() throws ClassNotFoundException, Exception {
        Categoria categoria = new Categoria(0, "Teste Cliente", "Teste Categoria");
        
        categoriaJdbc.create(categoria);
        
        assertNotNull(categoria);
        assertTrue(categoria.getId() != 0);
        
        categoriaJdbc.delete(categoria.getId());
        
        Categoria categoriaPersistente = categoriaJdbc.find(categoria.getId());
          
        assertNull(categoriaPersistente);
    }

    @Test
    public void testCountAll() {
    }
    
}
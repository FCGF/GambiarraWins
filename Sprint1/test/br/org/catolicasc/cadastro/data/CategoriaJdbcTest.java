/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.cadastro.data;

import br.org.catolicasc.cadastro.data.ConnectionManager;
import br.org.catolicasc.cadastro.data.CategoriaJdbc;
import br.org.catolicasc.cadastro.model.Categoria;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author GambiarraWins
 */
public class CategoriaJdbcTest {
    
    public CategoriaJdbcTest() {
    }
    
   private static CategoriaJdbc categoriaJdbc;

    @BeforeClass
    public static void setUpClass() throws Exception {
        categoriaJdbc = new CategoriaJdbc(ConnectionManager.getInstance());
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        categoriaJdbc = null;
    }


    @Test
    public void testFindAll() throws Exception {
        List<Categoria> categorias = categoriaJdbc.findAll();
        
        assertNotNull(categorias);
        assertTrue(categorias.size() > 0);
    }

    @Test
    public void testFindById() throws Exception {
         final int CUSTOMER_ID = 1;
         Categoria actual = categoriaJdbc.findById(CUSTOMER_ID);
         assertNotNull(actual);
         assertEquals(CUSTOMER_ID, actual.getId());
    }

    @Test
    public void testCreate() throws Exception {
        Categoria categoria = new Categoria(0, "s", "desc");
        
        categoriaJdbc.create(categoria);
        
        
        assertNotNull(categoria);
        assertTrue(categoria.getId() != 0);

        Categoria categoriaPersistente = categoriaJdbc.findById(categoria.getId());

        assertEquals(categoria.getId(), categoriaPersistente.getId());
        assertEquals(categoria.getNome(), categoriaPersistente.getNome());
        assertEquals(categoria.getDescricao(), categoriaPersistente.getDescricao());
    }

    @Test
    public void testUpdate() throws Exception {
        Categoria categoria = new Categoria(0, "Teste ", "Teste Descrição");
        categoriaJdbc.create(categoria);
        assertNotNull(categoria);
        assertTrue(categoria.getId() != 0);

        Categoria categoriaPersistente = categoriaJdbc.findById(categoria.getId());
        
        assertNotNull(categoriaPersistente);
        assertEquals(categoria.getId(), categoriaPersistente.getId());
        assertEquals(categoria.getNome(), categoriaPersistente.getNome());
        assertEquals(categoria.getDescricao(), categoriaPersistente.getDescricao());
        
        categoria.setNome("Cliente Modificado.");
        categoria.setDescricao("Descrição Modificada");
        
        categoriaJdbc.update((categoria));
        
        categoriaPersistente = categoriaJdbc.findById(categoria.getId());
        
        assertNotNull(categoriaPersistente);
        assertEquals(categoria.getId(), categoriaPersistente.getId());
        assertEquals(categoria.getNome(), categoriaPersistente.getNome());
        assertEquals(categoria.getDescricao(), categoriaPersistente.getDescricao());
    }

    @Test
    public void testDelete() throws Exception {
        
        List<Categoria> categorias = categoriaJdbc.findAll();

        assertNotNull(categorias);

        Categoria categoriaPersistente = categorias.get(categorias.size() - 1);

        System.out.println("Excluir: " + categoriaPersistente);

        categoriaJdbc.delete(categoriaPersistente);

        categoriaPersistente = categoriaJdbc.findById(categoriaPersistente.getId());

        assertNull(categoriaPersistente);
    }

    @Test
    public void testDeleteAll() throws Exception {
         
    }

    @Test
    public void testCountAll() throws Exception {
        int actual = categoriaJdbc.countAll();
        assertTrue(actual > 0);
    }
    
}

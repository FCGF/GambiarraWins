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
 * @author flavio.kannenberg
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
    }

    @Test
    public void testCreate() throws Exception {
    }

    @Test
    public void testUpdate() throws Exception {
    }

    @Test
    public void testDelete() throws Exception {
    }

    @Test
    public void testDeleteAll() throws Exception {
    }

    @Test
    public void testCountAll() throws Exception {
    }
    
}

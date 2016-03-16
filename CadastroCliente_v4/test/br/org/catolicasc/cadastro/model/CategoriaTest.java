
package br.org.catolicasc.cadastro.model;

import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class CategoriaTest {

    private Categoria categoria = null;

    @Before
    public void setUp() throws Exception {
        categoria = new Categoria();
    }

    @After
    public void tearDown() throws Exception {
        categoria = null;
    }

    
    @Test
    public void testGet()  {  
        
        
    }

    @Test
    public void testSetGetId() {

        final int CATEGOTIA_ID = 456;
        
        assertEquals(0, categoria.getId());
        
        categoria.setId(CATEGOTIA_ID);
        assertEquals(CATEGOTIA_ID, categoria.getId());
    }

    @Test
    public void testGetNome() {
    }

    @Test
    public void testSetNome() {
    }

    @Test
    public void testGetDescricao() {
    }

    @Test
    public void testSetDescricao() {
    }

    @Test
    public void testToString() {
    }
    
}

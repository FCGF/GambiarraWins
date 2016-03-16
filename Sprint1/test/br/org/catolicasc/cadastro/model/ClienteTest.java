/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.cadastro.model;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author GambiarraWins
 */
public class ClienteTest {
     private Cliente cliente = null;
    
    public ClienteTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @Before
    public void setUp() {
        cliente = new Cliente();
    }
    
    @After
    public void tearDown() {
        cliente = null;
    }

    @Test
    public void testGetId() {
       
        
        assertEquals(0, cliente.getId());
        
        
    }

    @Test
    public void testSetId() {
        final int CLIENTE_ID = 456;
        cliente.setId(CLIENTE_ID);
        assertEquals(CLIENTE_ID, cliente.getId());
        
    }

    @Test
    public void testGetNome() {
        //assertNotNull(cliente.getNome());
    }

    @Test
    public void testSetNome() {
    }

    @Test
    public void testIsAtivo() {
    }

    @Test
    public void testSetAtivo() {
    }

    @Test
    public void testToString() {
    }
    
}

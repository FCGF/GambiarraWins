/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.estrutural.proxy.poc;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admin
 */
public class BancoUsuariosTest {
    
    public BancoUsuariosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getNumeroDeUsuarios method, of class BancoUsuarios.
     */
    @Test
    public void testGetNumeroDeUsuarios() {
        System.out.println("getNumeroDeUsuarios");
        BancoUsuarios instance = new BancoUsuarios();
        String expResult = "";
        String result = instance.getNumeroDeUsuarios();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsuariosConectados method, of class BancoUsuarios.
     */
    @Test
    public void testGetUsuariosConectados() {
        System.out.println("getUsuariosConectados");
        BancoUsuarios instance = new BancoUsuarios();
        String expResult = "";
        String result = instance.getUsuariosConectados();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

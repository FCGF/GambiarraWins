/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.estrutura.proxy.modelo;

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
public class ProxyTest {
    
    public ProxyTest() {
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
     * Test of RequestProxy method, of class Proxy.
     */
    @Test
    public void testRequestProxy() {
        System.out.println("RequestProxy");
        String nomeDoArquivo = "";
        Proxy instance = null;
        instance.RequestProxy(nomeDoArquivo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getArquivos method, of class Proxy.
     */
    @Test
    public void testGetArquivos() {
        System.out.println("getArquivos");
        Proxy instance = null;
        instance.getArquivos();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

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
public class RealSubjectTest {
    
    public RealSubjectTest() {
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
     * Test of Request method, of class RealSubject.
     */
    @Test
    public void testRequest() {
        System.out.println("Request");
        RealSubject instance = null;
        instance.Request();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of arquivoReal method, of class RealSubject.
     */
    @Test
    public void testArquivoReal() {
        System.out.println("arquivoReal");
        String real = "";
        RealSubject instance = null;
        String expResult = "";
        String result = instance.arquivoReal(real);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getArquivos method, of class RealSubject.
     */
    @Test
    public void testGetArquivos() {
        System.out.println("getArquivos");
        RealSubject instance = null;
        instance.getArquivos();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

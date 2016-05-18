/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.criacao.builder.poc;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cyber
 */
public class ConcessionariaDirectorTest {
    
    
    @Test
    public void testConstruirCarro() {
        System.out.println("construirCarro");
        ConcessionariaDirector instance = null;
        instance.construirCarro();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCarro method, of class ConcessionariaDirector.
     */
    @Test
    public void testGetCarro() {
        System.out.println("getCarro");
        ConcessionariaDirector instance = null;
        CarroProduct expResult = null;
        CarroProduct result = instance.getCarro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

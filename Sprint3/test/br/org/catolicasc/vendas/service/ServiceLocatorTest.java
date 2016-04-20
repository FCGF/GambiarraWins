/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.vendas.service;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cyber
 */
public class ServiceLocatorTest {
    
    public ServiceLocatorTest() {
    }
    
    

    @Test
    public void testGetIService() {
        final String serviceName = "produtoService";
        IService expected = ServiceLocator.getService(serviceName);
        assertNotNull(expected);
        
        IService actual = ServiceLocator.getService(serviceName);
        assertEquals(expected, actual);
    }
    
}

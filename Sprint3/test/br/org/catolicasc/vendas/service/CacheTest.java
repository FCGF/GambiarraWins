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
public class CacheTest {
    
    private static Cache cache;
    public CacheTest() {
    }
    
    @BeforeClass
    public  static void setUpClass() {
        cache = new Cache();
    }

    @Test
    public void testResolve() {
        final String serviceNameA = "produtoService";
        final String serviceNameB = "clienteService";
        
        cache.register(serviceNameA, ProdutoService.getInstance());
        cache.register(serviceNameB, ProdutoService.getInstance());
        
        assertEquals(ProdutoService.getInstance(), cache.resolve(serviceNameA));
        assertEquals(ProdutoService.getInstance(), cache.resolve(serviceNameB));
    }

    @Test
    public void testRegister() {
    }
    
}

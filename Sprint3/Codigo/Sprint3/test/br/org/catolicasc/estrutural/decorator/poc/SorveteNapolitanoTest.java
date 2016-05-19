/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.estrutural.decorator.poc;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author rafa-
 */
public class SorveteNapolitanoTest {
    
    private Sorvete sorvete;
    
    @Before
    public void setUp() throws Exception {
        sorvete = new SorveteNapolitano();
    }
    
    @Test
    public void testGetQntBolas() {
        sorvete = new Chocolate(sorvete);
        assertEquals(1, sorvete.getQntBolas());
        
        sorvete = new Creme(sorvete);
        assertEquals(2, sorvete.getQntBolas());
        
        sorvete = new Morango(sorvete);
        assertEquals(3, sorvete.getQntBolas());
    }

    @Test
    public void testGetPreco() {
        sorvete = new Chocolate(sorvete);
        double preco = sorvete.getPreco();
        assertEquals(4, preco, 0);
        
        sorvete = new Creme(sorvete);
        preco = sorvete.getPreco();
        assertEquals(5.25, preco, 0);
        
        sorvete = new Morango(sorvete);
        preco = sorvete.getPreco();
        assertEquals(7, preco, 0);
        
    }
    
}

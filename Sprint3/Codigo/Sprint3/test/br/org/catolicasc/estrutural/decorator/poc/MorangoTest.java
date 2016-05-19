/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.estrutural.decorator.poc;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author rafa-
 */
public class MorangoTest {
    
    private static Sorvete sorvete;
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        sorvete = new SorveteNapolitano();
        sorvete = new Morango(sorvete);
    }

    @Test
    public void testGetQntBolas() {
        int resultado = sorvete.getQntBolas();
        assertEquals(1, resultado);
    }

    @Test
    public void testGetPreco() {
        double preco = sorvete.getPreco();
        assertEquals(4.25, preco, 0);
    }
    
}

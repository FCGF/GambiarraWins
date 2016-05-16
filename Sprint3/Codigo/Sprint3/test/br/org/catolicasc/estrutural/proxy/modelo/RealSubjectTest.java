/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.estrutural.proxy.modelo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admin
 */
public class RealSubjectTest {

    /**
     * Test of arquivoReal method, of class RealSubject.
     */
    @Test
    public void testArquivoReal() {
        String real = "Nome";
        System.out.println("arquivoReal");
        RealSubject instance = new RealSubject(real);
        String result = instance.arquivoReal(real);
        assertEquals(real, result);

    }

    public void testArquivoRealErrado() {
        String real = "Nome";
        System.out.println("ArquivoRealErrado");
        RealSubject instance = new RealSubject("Gambiarra");
        String result = instance.arquivoReal(real);
        assertEquals(real, result);

    }

}

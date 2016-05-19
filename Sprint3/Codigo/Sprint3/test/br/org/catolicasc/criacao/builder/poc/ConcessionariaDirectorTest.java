/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.criacao.builder.poc;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cyber
 */
public class ConcessionariaDirectorTest {

    @Test
    public void testConstruirCarroFiat() {
        System.out.println("construirCarro");
        CarroBuilder fiat = new FiatBuilder();
        ConcessionariaDirector fiatTest = new ConcessionariaDirector(fiat);
        fiatTest.construirCarro();
        assertEquals(1000.00, fiat.getCarro().getPreco(), 0);
        assertEquals("1.0 Flex", fiat.getCarro().getDscMotor());
        assertEquals(2010, fiat.getCarro().getAnoDeFabricacao());
        assertEquals("Palio", fiat.getCarro().getModelo());
        assertEquals("Fiat", fiat.getCarro().getMontadora());

    }

    @Test
    public void testConstruirCarroVolks() {
        System.out.println("construirCarro");
        CarroBuilder volk = new VolksBuilder();
        ConcessionariaDirector volkTest = new ConcessionariaDirector(volk);
        volkTest.construirCarro();
        assertEquals(1000.00, volk.getCarro().getPreco(), 0);
        assertEquals("1.0 Flex", volk.getCarro().getDscMotor());
        assertEquals(2010, volk.getCarro().getAnoDeFabricacao());
        assertEquals("Gol", volk.getCarro().getModelo());
        assertEquals("VolskWagem", volk.getCarro().getMontadora());

    }

}

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
public class ProxyTest {

    /**
     * Test of RequestProxy method, of class Proxy.
     */
    @Test
    public void testRequestProxy() {
        System.out.println("RequestProxy");
        String nomeDoArquivo = "Nome";
        Proxy instance = new Proxy("Nome");
        instance.RequestProxy(nomeDoArquivo);
        assertNotNull(nomeDoArquivo);
        assertFalse(nomeDoArquivo.isEmpty());

    }

    /**
     * Test of getArquivos method, of class Proxy.
     */
    @Test
    public void testGetArquivos() {
        System.out.println("getArquivos");
        Proxy instance = new Proxy("Nome");
        instance.getArquivos();
        String nomeDoArquivo = "Nome";
        assertNotNull(nomeDoArquivo);
        assertFalse(nomeDoArquivo.isEmpty());
    }

}

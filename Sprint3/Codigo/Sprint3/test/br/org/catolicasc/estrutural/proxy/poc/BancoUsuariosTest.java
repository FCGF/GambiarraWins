/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.estrutural.proxy.poc;

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
public class BancoUsuariosTest {
    
  

    /**
     * Test of getNumeroDeUsuarios method, of class BancoUsuarios.
     */
    @Test
    public void testGetNumeroDeUsuarios() {
        System.out.println("getNumeroDeUsuarios");
        BancoUsuarios instance = new BancoUsuarios();
        String result = instance.getNumeroDeUsuarios();
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    /**
     * Test of getUsuariosConectados method, of class BancoUsuarios.
     */
    @Test
    public void testGetUsuariosConectados() {
        System.out.println("getUsuariosConectados");
        BancoUsuarios instance = new BancoUsuarios();
        String result = instance.getUsuariosConectados();
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }
    
}

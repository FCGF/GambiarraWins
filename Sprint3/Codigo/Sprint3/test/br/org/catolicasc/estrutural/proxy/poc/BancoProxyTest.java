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
public class BancoProxyTest {

    /**
     * Test of getNumeroDeUsuarios method, of class BancoProxy.
     */
    @Test
    public void testGetNumeroDeUsuariosSenhaUsuarioErrados() {
        System.out.println("GetNumeroDeUsuariosSenhaUsuarioErrados");
        BancoProxy instance = new BancoProxy("Joao", "123");
        String result = instance.getNumeroDeUsuarios();
        assertNull(result);
    }

    @Test
    public void testGetNumeroDeUsuariosSenhaUsuarioCertos() {
        System.out.println("GetNumeroDeUsuariosSenhaUsuarioCertos");
        BancoProxy instance = new BancoProxy("admin", "admin");
        String result = instance.getNumeroDeUsuarios();
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    public void testGetNumeroDeUsuariosSenhaErrada() {
        System.out.println("GetNumeroDeUsuariosSenhaErrada");
        BancoProxy instance = new BancoProxy("admin", "123");
        String result = instance.getNumeroDeUsuarios();
        assertNull(result);

    }

    @Test
    public void testGetNumeroDeUsuariosUsuarioErrados() {
        System.out.println("tGetNumeroDeUsuariosUsuarioErrados");
        BancoProxy instance = new BancoProxy("Joao", "admin");
        String result = instance.getNumeroDeUsuarios();
        assertNull(result);
    }

    /**
     * Test of getUsuariosConectados method, of class BancoProxy.
     */
    @Test
    public void testGetUsuariosConectadosSenhaUsuarioErrados() {
        System.out.println("GetUsuariosConectadosSenhaUsuarioErrados");
        BancoProxy instance = new BancoProxy("Joao", "123");
        String result = instance.getUsuariosConectados();
        assertNull(result);
    }

    @Test
    public void testGetUsuariosConectadosSenhaUsuarioCertos() {
        System.out.println("GetUsuariosConectadosSenhaUsuarioCertos");
        BancoProxy instance = new BancoProxy("admin", "admin");
        String result = instance.getUsuariosConectados();
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    public void testGetUsuariosConectadosSenhaErrada() {
        System.out.println("GetUsuariosConectadosSenhaErrada");
        BancoProxy instance = new BancoProxy("admin", "123");
        String result = instance.getUsuariosConectados();
        assertNull(result);

    }

    @Test
    public void testGetUsuariosConectadosUsuarioErrados() {
        System.out.println("GetUsuariosConectadosUsuarioErrados");
        BancoProxy instance = new BancoProxy("Joao", "admin");
        String result = instance.getUsuariosConectados();
        assertNull(result);
    }

}

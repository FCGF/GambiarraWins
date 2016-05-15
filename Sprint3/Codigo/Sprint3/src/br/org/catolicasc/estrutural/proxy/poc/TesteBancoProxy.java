/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.estrutural.proxy.poc;

/**
 *
 * @author geovane.camargo
 */
public class TesteBancoProxy {

    public static void main(String[] args) {
        
        System.out.println("Hacker acessando");
        BancoUsuarios banco = new BancoProxy("Hacker", "1234");
        System.out.println(banco.getNumeroDeUsuarios());
        System.out.println(banco.getUsuariosConectados());

        System.out.println("\nAdministrador acessando");
        banco = new BancoProxy("admin", "admin");
        System.out.println(banco.getNumeroDeUsuarios());
        System.out.println(banco.getUsuariosConectados());
    }
}

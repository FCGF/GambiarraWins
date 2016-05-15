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
public class BancoUsuarios {

    private int quantidadeDeUsuarios;
    private int usuariosConectados;
 
    public BancoUsuarios() {
        quantidadeDeUsuarios = (int) (Math.random() * 100);
        usuariosConectados = (int) (Math.random() * 10);
    }
 
    public String getNumeroDeUsuarios() {
        return new String("Total de usuários: " + quantidadeDeUsuarios);
    }
 
    public String getUsuariosConectados() {
        return new String("Usuários conectados: " + usuariosConectados);
    }
    
}

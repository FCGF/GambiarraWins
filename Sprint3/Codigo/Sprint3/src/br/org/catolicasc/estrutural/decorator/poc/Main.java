/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.estrutural.decorator.poc;

/**
 *
 * @author Guilherme
 */
public class Main {
    public static void main(String[] args) {
        
        Sorvete sorvete = new SorveteNapolitano();
        
        retornaInformacoes(sorvete);
        
        sorvete = new Creme(sorvete);

        retornaInformacoes(sorvete);
        
        
    }
    public static void retornaInformacoes(Sorvete sorvete){
        System.out.println(sorvete.getNome() + " - " + 
                sorvete.getQntBolas() + " bolas -  preco: R$" + 
                sorvete.getPreco());
    }
    
}

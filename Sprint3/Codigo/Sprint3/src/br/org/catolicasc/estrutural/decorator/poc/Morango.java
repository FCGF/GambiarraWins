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
public class Morango extends SorveteSabor {
    
    public Morango(Sorvete sorvete) {
        super(sorvete);
    }

    @Override
    public int getQntBolas() {
        return 1 + this.getSorvete().getQntBolas();
    }

    @Override
    public double getPreco() {
        return 1.75 + this.getSorvete().getPreco();
    }
    
}

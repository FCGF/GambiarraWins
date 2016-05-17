
package br.org.catolicasc.estrutural.decorator.poc;


public abstract class SorveteSabor extends Sorvete{
    
    private Sorvete sorvete;

    public SorveteSabor(Sorvete sorvete) {
        this.sorvete = sorvete;
        sorvete.setNome("");
    }

    public Sorvete getSorvete() {
        return sorvete;
    }
    
}

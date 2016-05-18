
package br.org.catolicasc.estrutural.decorator.poc;


public abstract class SorveteSabor extends Sorvete{
    
    private Sorvete sorvete;

    public SorveteSabor(Sorvete sorvete) {
        this.sorvete = sorvete;
        //this.setNome(sorvete.getNome());//Para que o nome nao fique null
    }

    public Sorvete getSorvete() {
        return sorvete;
    }
    
}


package br.org.catolicasc.estrutural.decorator.poc;


public class SorveteNapolitano extends Sorvete {

    public SorveteNapolitano(){
        this.setNome("Sorvete Napolitano");
    }
    
    @Override
    public int getQntBolas() {
        return 0;
    }

    @Override
    public double getPreco() {
        return 2.5;
    }
    
}

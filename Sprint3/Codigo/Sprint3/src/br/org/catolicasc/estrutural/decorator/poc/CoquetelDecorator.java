
package br.org.catolicasc.estrutural.decorator.poc;

public class CoquetelDecorator extends Coquetel{
    
    Coquetel coquetel;

    public CoquetelDecorator(Coquetel umCoquetel) {
	coquetel = umCoquetel;
    }

    @Override
    public String getNome() {
        return coquetel.getNome() + " + " + nome;
    }

    public double getPreco() {
	return coquetel.getPreco() + preco;
    }
}

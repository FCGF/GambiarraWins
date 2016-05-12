package br.org.catolicasc.estrutural.decorator.poc;

public class Refrigerante extends CoquetelDecorator{
    
    public Refrigerante(Coquetel umCoquetel){
	super(umCoquetel);
	nome = "Refrigerante";
	preco = 1.0;
    }
    
}

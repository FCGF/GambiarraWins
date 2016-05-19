package br.org.catolicasc.estrutura.decorator.modelo;

public abstract class Decorador extends Componente {

    private Componente componente;

    public Decorador(Componente componente) {
        this.componente = componente;
    }

    public void operacao() {
        componente.operacao();
        System.out.println("Operacao!");
    }

}

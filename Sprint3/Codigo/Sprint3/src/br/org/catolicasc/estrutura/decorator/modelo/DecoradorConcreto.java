package br.org.catolicasc.estrutura.decorator.modelo;

public class DecoradorConcreto extends Decorador {

    public DecoradorConcreto(Componente componente) {
        super(componente);
    }

    public void operacao() {
        System.out.println("Operacao!");
    }

    public void comportamentoAdicionado() {
        System.out.println("Comportamento adicionado");
    }

}

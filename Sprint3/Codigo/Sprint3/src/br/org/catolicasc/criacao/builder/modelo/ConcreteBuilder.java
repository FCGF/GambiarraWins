package br.org.catolicasc.criacao.builder.modelo;

public class ConcreteBuilder extends Builder {

    @Override
    public void BuildPart() {

        object.setPart("part"); 
    }

    public Product GetResult() {

        return object;
    }

}

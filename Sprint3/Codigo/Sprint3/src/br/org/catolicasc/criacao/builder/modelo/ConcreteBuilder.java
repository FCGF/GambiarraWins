package br.org.catolicasc.criacao.builder.modelo;

public class ConcreteBuilder extends Builder {

    @Override
    public void BuildPart() {

        object.part = "part";
    }

    public Product GetResult() {

        return object;
    }

}

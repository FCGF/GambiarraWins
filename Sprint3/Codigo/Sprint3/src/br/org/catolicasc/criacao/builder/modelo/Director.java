package br.org.catolicasc.criacao.builder.modelo;

public class Director {

    protected Builder object;

    public Director(Builder object) {
        this.object = object;
    }

    public void Construct() {

        object.BuildPart();
    }

}

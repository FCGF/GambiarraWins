package br.org.catolicasc.vendas.model;

public enum UnidadePeso {

    QUILOGRAMA("kq", 1.0),
    GRAMA("g", 1000.0),
    TONELADA("t", (1.0 / 1000.0));

    private String simbolo;
    private double quilo;

    private UnidadePeso(String simbolo, double quilo) {
        this.simbolo = simbolo;
        this.quilo = quilo;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public double getQuilo() {
        return quilo;
    }

    public void setQuilo(double quilo) {
        this.quilo = quilo;
    }

}

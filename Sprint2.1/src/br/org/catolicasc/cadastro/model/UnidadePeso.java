package br.org.catolicasc.cadastro.model;

/**
 *
 * @author GambiarraWins
 */
public enum UnidadePeso {
    QUILOGRAMA(1.0),
    GRAMA(1000.0),
    TONELADA(0.001);

    private UnidadePeso(double valorKilo) {
        this.valorKilo = valorKilo;
    }

    private final double valorKilo;

    protected double getFator() {
        return valorKilo;
    }

    public double converteA(UnidadePeso unidade, double valor) {
        return valor * unidade.getFator() / this.getFator();
    }

    public static UnidadePeso parse(int indice) {
        UnidadePeso unidade = null;
        switch (indice) {
            case 0:
                unidade = QUILOGRAMA;
                break;
            case 1:
                unidade = GRAMA;
                break;
            case 2:
                unidade = TONELADA;
                break;
        }
        return unidade;
    }
}

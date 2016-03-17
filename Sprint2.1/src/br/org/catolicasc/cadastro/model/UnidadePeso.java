package br.org.catolicasc.cadastro.model;

/**
 *
 * @author GambiarraWins
 */
public enum UnidadePeso {
    QUILOGRAMA,
    GRAMA,
    TONELADA;

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

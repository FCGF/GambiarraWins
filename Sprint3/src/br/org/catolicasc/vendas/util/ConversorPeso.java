package br.org.catolicasc.vendas.util;

import br.org.catolicasc.vendas.model.UnidadePeso;

/**
 *
 * @author fkannenberg
 */
public final class ConversorPeso {

    private ConversorPeso() {
        super();
    }

    public static double ConverterUnidade(double valor, UnidadePeso de, UnidadePeso para) {
        return ((valor / de.getQuilo()) * para.getQuilo());
    }
}

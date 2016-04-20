package br.org.catolicasc.vendas.util;

import br.org.catolicasc.vendas.model.UnidadePeso;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author GambiarraWins
 */
public class ConversorPesoTest {

    @Test
    public void testConverterUnidade() {
        assertEquals(1.0, ConversorPeso.ConverterUnidade(1.0, UnidadePeso.GRAMA, UnidadePeso.GRAMA), 0.0);
        assertEquals(1.0, ConversorPeso.ConverterUnidade(1.0, UnidadePeso.QUILOGRAMA, UnidadePeso.QUILOGRAMA), 0.0);
        assertEquals(1.0, ConversorPeso.ConverterUnidade(1.0, UnidadePeso.TONELADA, UnidadePeso.TONELADA), 0.0);

        assertEquals(0.001, ConversorPeso.ConverterUnidade(1.0, UnidadePeso.GRAMA, UnidadePeso.QUILOGRAMA), 0.0);
        assertEquals(1000.0, ConversorPeso.ConverterUnidade(1.0, UnidadePeso.QUILOGRAMA, UnidadePeso.GRAMA), 0.0);

        assertEquals(0.001, ConversorPeso.ConverterUnidade(1.0, UnidadePeso.QUILOGRAMA, UnidadePeso.TONELADA), 0.0);
        assertEquals(1000.0, ConversorPeso.ConverterUnidade(1.0, UnidadePeso.TONELADA, UnidadePeso.QUILOGRAMA), 0.0);

        assertEquals(((1 / 1000) / 1000), ConversorPeso.ConverterUnidade(1.0, UnidadePeso.GRAMA, UnidadePeso.TONELADA), 0.01);
    }

}

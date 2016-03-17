package br.org.catolicasc.cadastro.model;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author GambiarraWins
 */
public class UnidadePesoTest {

    public UnidadePesoTest() {
    }

    @Test
    public void testQuilogramaParaQuilograma() {
        final UnidadePeso atual = UnidadePeso.QUILOGRAMA;
        final double valorAtual = 10.0;
        final double valorKilo = atual.converteA(UnidadePeso.QUILOGRAMA, valorAtual);
        assertEquals(valorAtual, valorKilo, 0);
    }

    @Test
    public void testGramaParaQuilograma() {
        final UnidadePeso atual = UnidadePeso.GRAMA;
        final double valorAtual = 1000.0;
        final double valorKilo = atual.converteA(UnidadePeso.QUILOGRAMA, valorAtual);
        assertEquals(valorAtual / 1000, valorKilo, 0);
    }

    @Test
    public void testToneladaParaQuilograma() {
        final UnidadePeso atual = UnidadePeso.TONELADA;
        final double valorAtual = 10.0;
        final double valorKilo = atual.converteA(UnidadePeso.QUILOGRAMA, valorAtual);
        assertEquals(valorAtual * 1000.0, valorKilo, 0);
    }

}

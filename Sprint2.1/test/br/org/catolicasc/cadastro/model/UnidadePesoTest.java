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
    public void testQuilogramaParaGrama() {
        final UnidadePeso atual = UnidadePeso.QUILOGRAMA;
        final double valorAtual = 10.0;
        final double valorKilo = atual.converteA(UnidadePeso.GRAMA, valorAtual);
        assertEquals(valorAtual * 1000.0, valorKilo, 0);
    }

    @Test
    public void testQuilogramaParaQuilograma() {
        final UnidadePeso atual = UnidadePeso.QUILOGRAMA;
        final double valorAtual = 10.0;
        final double valorKilo = atual.converteA(UnidadePeso.QUILOGRAMA, valorAtual);
        assertEquals(valorAtual, valorKilo, 0);
    }

    @Test
    public void testQuilogramaParaTonelada() {
        final UnidadePeso atual = UnidadePeso.QUILOGRAMA;
        final double valorAtual = 1000.0;
        final double valorKilo = atual.converteA(UnidadePeso.TONELADA, valorAtual);
        assertEquals(valorAtual / 1000.0, valorKilo, 0);
    }

    @Test
    public void testGramaParaGrama() {
        final UnidadePeso atual = UnidadePeso.GRAMA;
        final double valorAtual = 1000.0;
        final double valorKilo = atual.converteA(UnidadePeso.GRAMA, valorAtual);
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
    public void testGramaParaTonelada() {
        final UnidadePeso atual = UnidadePeso.GRAMA;
        final double valorAtual = 1000.0;
        final double valorKilo = atual.converteA(UnidadePeso.TONELADA, valorAtual);
        assertEquals(valorAtual / 1000000, valorKilo, 0);
    }

    @Test
    public void testToneladaParaGrama() {
        final UnidadePeso atual = UnidadePeso.TONELADA;
        final double valorAtual = 1.0;
        final double valorKilo = atual.converteA(UnidadePeso.GRAMA, valorAtual);
        assertEquals(valorAtual * 1000000.0, valorKilo, 0);
    }

    @Test
    public void testToneladaParaQuilograma() {
        final UnidadePeso atual = UnidadePeso.TONELADA;
        final double valorAtual = 10.0;
        final double valorKilo = atual.converteA(UnidadePeso.QUILOGRAMA, valorAtual);
        assertEquals(valorAtual * 1000.0, valorKilo, 0);
    }

    @Test
    public void testToneladaParaTonelada() {
        final UnidadePeso atual = UnidadePeso.TONELADA;
        final double valorAtual = 10.0;
        final double valorKilo = atual.converteA(UnidadePeso.TONELADA, valorAtual);
        assertEquals(valorAtual, valorKilo, 0);
    }

    @Test
    public void testParseZero() {
        assertEquals(UnidadePeso.parse(0), UnidadePeso.QUILOGRAMA);
    }

    @Test
    public void testParseUm() {
        assertEquals(UnidadePeso.parse(1), UnidadePeso.GRAMA);
    }

    @Test
    public void testParseDois() {
        assertEquals(UnidadePeso.parse(2), UnidadePeso.TONELADA);
    }

    @Test
    public void testParseTres() {
        assertEquals(UnidadePeso.parse(3), null);
    }
}

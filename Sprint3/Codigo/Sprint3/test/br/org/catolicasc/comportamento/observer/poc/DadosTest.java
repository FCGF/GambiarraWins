package br.org.catolicasc.comportamento.observer.poc;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fernando
 */
public class DadosTest {

    @Test
    public void testSetValorA() {
        System.out.println("setValorA");
        int valorA = 10;
        Dados instance = new Dados();
        instance.setValorA(valorA);
        assertEquals(valorA, instance.getValorA());
    }

    @Test
    public void testSetValorB() {
        System.out.println("setValorB");
        int valorB = 20;
        Dados instance = new Dados();
        instance.setValorB(valorB);
        assertEquals(valorB, instance.getValorB());
    }

    @Test
    public void testSetValorC() {
        System.out.println("setValorC");
        int valorC = 30;
        Dados instance = new Dados();
        instance.setValorC(valorC);
        assertEquals(valorC, instance.getValorC());
    }

}

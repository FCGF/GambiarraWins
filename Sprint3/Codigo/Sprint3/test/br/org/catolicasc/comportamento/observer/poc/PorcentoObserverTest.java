package br.org.catolicasc.comportamento.observer.poc;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fernando
 */
public class PorcentoObserverTest {

    @Test
    public void testUpdate() {
        System.out.println("update");
        DadosSubject subject = new DadosSubject();
        PorcentoObserver instance = new PorcentoObserver(subject);
        subject.attach(instance);

        subject.setState(new Dados(1, 2, 3));
        subject.setState(new Dados(10, 7, 4));

        assertEquals(subject.getState(), instance.getDados());
        instance.update();
        assertEquals(subject.getState(), instance.getDados());
    }

}

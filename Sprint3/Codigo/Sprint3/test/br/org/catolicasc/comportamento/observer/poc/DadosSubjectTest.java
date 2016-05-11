package br.org.catolicasc.comportamento.observer.poc;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fernando
 */
public class DadosSubjectTest {

    @Test
    public void testSetState() {
        DadosSubject subject = new DadosSubject();

        subject.setState(new Dados(1, 2, 3));

        Dados expected = new Dados(10, 7, 4);
        subject.setState(expected);

        assertEquals(expected, subject.getState());
    }

}

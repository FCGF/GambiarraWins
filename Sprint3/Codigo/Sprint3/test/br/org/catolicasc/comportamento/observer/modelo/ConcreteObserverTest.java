package br.org.catolicasc.comportamento.observer.modelo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fernando
 */
public class ConcreteObserverTest {

    @Test
    public void testUpdate() {
        System.out.println("update");
        ConcreteSubject subject = new ConcreteSubject();
        ConcreteObserver instance = new ConcreteObserver(subject);
        subject.attach(instance);
        subject.setState(1);

        assertEquals(subject.getState(), instance.getObserverState());

        instance.update();
        assertEquals(subject.getState(), instance.getObserverState());
    }

}

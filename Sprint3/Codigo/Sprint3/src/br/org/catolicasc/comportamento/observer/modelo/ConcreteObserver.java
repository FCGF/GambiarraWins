package br.org.catolicasc.comportamento.observer.modelo;

/**
 *
 * @author Fernando
 */
public class ConcreteObserver extends Observer {

    private Object observerState;
    private ConcreteSubject subject;

    public ConcreteObserver(ConcreteSubject subject) {
        this.subject = subject;
    }

    @Override
    public void update() {
        observerState = subject.getState();
    }

}

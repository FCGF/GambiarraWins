package br.org.catolicasc.comportamento.observer.modelo;

/**
 *
 * @author Fernando
 */
public class ConcreteObserver extends Observer {

    private Object observerState;
    protected ConcreteSubject subject;

    public ConcreteObserver(ConcreteSubject subject) {
        this.subject = subject;
    }

    @Override
    public void update() {
        observerState = subject.getState();
    }

    public Object getObserverState() {
        return observerState;
    }

}

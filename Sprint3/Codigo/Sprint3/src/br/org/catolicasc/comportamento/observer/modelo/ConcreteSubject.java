package br.org.catolicasc.comportamento.observer.modelo;

/**
 *
 * @author Fernando
 */
public class ConcreteSubject extends Subject {
    private Object subjectState;
    
    public void setState(Object subject) {
        subjectState = subject;
        notifyObservers();
    }
    
    public Object getState() {
        return subjectState;
    }
    
}

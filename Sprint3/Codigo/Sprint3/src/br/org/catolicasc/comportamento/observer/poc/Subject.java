package br.org.catolicasc.comportamento.observer.poc;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fernando
 */
public abstract class Subject {

    protected List<IObserver> observers;

    public Subject() {
        observers = new ArrayList<>();
    }

    public void attach(IObserver observer) {
        observers.add(observer);
    }

    public void detach(int index) {
        observers.remove(index);
    }

    public void notifyObservers() {
        for (IObserver o : observers) {
            o.update();
        }
    }

}

package br.org.catolicasc.comportamento.observer.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fernando
 */
public abstract class Subject {
    protected List<Observer> observers;

    public Subject() {
        observers = new ArrayList<>();
    }
    
    public void attach(Observer observer) {
        observers.add(observer);
    }
    
    public void detach(Observer observer){
        observers.remove(observer);
    }
    
    public void notifyObservers() {
        for(Observer o : observers){
            o.update();
        }
    }
    
}

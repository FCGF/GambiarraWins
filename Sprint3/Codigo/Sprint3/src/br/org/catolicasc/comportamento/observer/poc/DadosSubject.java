package br.org.catolicasc.comportamento.observer.poc;

/**
 *
 * @author Fernando
 */
public class DadosSubject extends Subject {

    private Dados dados;

    public void setState(Dados dados) {
        this.dados = dados;
        notifyObservers();
    }

    public Dados getState() {
        return dados;
    }

}

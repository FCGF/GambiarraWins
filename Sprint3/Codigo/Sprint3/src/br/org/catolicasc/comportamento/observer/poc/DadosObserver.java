package br.org.catolicasc.comportamento.observer.poc;

/**
 *
 * @author Fernando
 */
public abstract class DadosObserver implements IObserver {

    protected Dados dados;
    protected final DadosSubject subject;

    public DadosObserver(DadosSubject subject) {
        this.subject = subject;
    }

    @Override
    public void update() {
        dados = subject.getState();
    }

    public Dados getDados() {
        return dados;
    }
}

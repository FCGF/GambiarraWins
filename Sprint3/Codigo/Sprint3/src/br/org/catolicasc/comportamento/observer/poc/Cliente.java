package br.org.catolicasc.comportamento.observer.poc;

/**
 *
 * @author Fernando
 */
public class Cliente {

    public static void main(String[] args) {
        DadosSubject subject = new DadosSubject();

        subject.attach(new TabelaObserver(subject));
        subject.attach(new PorcentoObserver(subject));
        subject.attach(new BarraObserver(subject));

        subject.setState(new Dados(1, 2, 3));
        subject.setState(new Dados(10, 7, 4));
    }
}

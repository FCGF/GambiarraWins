package br.org.catolicasc.comportamento.observer.poc;

/**
 *
 * @author Fernando
 */
public class TabelaObserver extends DadosObserver {

    public TabelaObserver(DadosSubject subject) {
        super(subject);
    }

    @Override
    public void update() {
        super.update();
        System.out.println(String.format("Tabela:\nValor A: %d\nValor B: %d\nValor C: %d",
                dados.getValorA(), dados.getValorB(), dados.getValorC()));
    }

}

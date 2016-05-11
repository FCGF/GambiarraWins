package br.org.catolicasc.comportamento.observer.poc;

/**
 *
 * @author Fernando
 */
public class BarraObserver extends DadosObserver {

    public BarraObserver(DadosSubject subject) {
        super(subject);
    }

    @Override
    public void update() {
        super.update();
        String barraA = "";
        String barraB = "";
        String barraC = "";

        for (int i = 0; i < dados.getValorA(); i++) {
            barraA += '=';
        }

        for (int i = 0; i < dados.getValorB(); i++) {
            barraB += '=';
        }

        for (int i = 0; i < dados.getValorC(); i++) {
            barraC += '=';
        }

        System.out.println(String.format("Barras:\nValor A: %s\nValor B: %s\nValor C: %s",
                barraA, barraB, barraC));
    }
}

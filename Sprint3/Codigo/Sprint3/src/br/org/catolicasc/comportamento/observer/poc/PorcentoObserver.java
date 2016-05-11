package br.org.catolicasc.comportamento.observer.poc;

/**
 *
 * @author Fernando
 */
public class PorcentoObserver extends DadosObserver {

    public PorcentoObserver(DadosSubject subject) {
        super(subject);
    }

    @Override
    public void update() {
        super.update();
        int soma = dados.getValorA() + dados.getValorB() + dados.getValorC();
        final double porcentagemA = 100.0 * dados.getValorA() / soma;
        final double porcentagemB = 100.0 * dados.getValorB() / soma;
        final double porcentagemC = 100.0 * dados.getValorC() / soma;
        System.out.println(String.format("Porcentagem:\nValor A: %.2f%%\nValor B: %.2f%%\nValor C: %.2f%%",
                porcentagemA, porcentagemB, porcentagemC));
    }
}

package br.org.catolicasc.comportamento.observer.poc;

/**
 *
 * @author Fernando
 */
public class Dados {

    private int valorA;
    private int valorB;
    private int valorC;

    public Dados() {
        super();
    }

    public Dados(int valorA, int valorB, int valorC) {
        this();
        this.valorA = valorA;
        this.valorB = valorB;
        this.valorC = valorC;
    }

    public int getValorA() {
        return valorA;
    }

    public void setValorA(int valorA) {
        this.valorA = valorA;
    }

    public int getValorB() {
        return valorB;
    }

    public void setValorB(int valorB) {
        this.valorB = valorB;
    }

    public int getValorC() {
        return valorC;
    }

    public void setValorC(int valorC) {
        this.valorC = valorC;
    }

    @Override
    public boolean equals(Object obj) {
        boolean igual = false;
        if (obj instanceof Dados) {
            Dados dados = (Dados) obj;
            igual = this.getValorA() == dados.getValorA() && this.getValorB() == dados.getValorB() && this.getValorC() == dados.getValorC();
        }
        return igual;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.valorA;
        hash = 31 * hash + this.valorB;
        hash = 31 * hash + this.valorC;
        return hash;
    }

}

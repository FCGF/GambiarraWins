package br.org.catolicasc.cadastro.model;

/**
 *
 * @author GambiarraWins
 */
public class Produto extends Entity {

    private String nome;
    private double peso;
    private double qtdeDisponivel;
    private UnidadePeso unidade;

    public Produto() {
        super();
    }

    public Produto(int id, String nome) {
        super(id);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getQtdeDisponivel() {
        return qtdeDisponivel;
    }

    public void setQtdeDisponivel(double qtdeDisponivel) {
        this.qtdeDisponivel = qtdeDisponivel;
    }

    public UnidadePeso getUnidade() {
        return unidade;
    }

    public void setUnidade(UnidadePeso unidade) {
        this.unidade = unidade;
    }

    public void setUnidade(int indice) {
        setUnidade(UnidadePeso.parse(indice));
    }

    public double calculaPesoEmQuilo() {
        return UnidadePeso.converteAKilo(unidade, peso);
    }

    @Override
    public String toString() {
        return String.format("Produto=[ ID: %d, Nome: %s, Peso: %.2f, Quantidade Disponível: %.2f, Unidade Medida: %s ]",
                getId(), getNome(), getPeso(), getQtdeDisponivel(), getUnidade().name());
    }

}

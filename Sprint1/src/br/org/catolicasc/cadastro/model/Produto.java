package br.org.catolicasc.cadastro.model;

public class Produto extends Entity {

    private Categoria categoria;
    private String nome;
    private double precoUnitario;
    private double quantidade;
    private int estoque;
    private boolean descontinuado;

    public Produto() {
        super();
    }

    public Produto(int id) {
        super(id);
    }

    public Produto(int id, Categoria categoria, String nome, double precoUnitario, double quantidade, int estoque, boolean descontinuado) {
        this(id);
        this.categoria = categoria;
        this.nome = nome;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
        this.estoque = estoque;
        this.descontinuado = descontinuado;
    }


    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public boolean isDescontinuado() {
        return descontinuado;
    }

    public void descontinua() {
        this.descontinuado = true;
    }

    public void continua() {
        this.descontinuado = false;
    }

}

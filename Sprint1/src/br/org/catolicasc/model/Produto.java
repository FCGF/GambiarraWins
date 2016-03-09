
package br.org.catolicasc.model;

public class Produto {
    
    private int id;
    private Categoria categoria;
    private String nome;
    private double preco_unitario;
    private double quantidade;
    private int estoque; 
    private boolean descontinuado;

    public Produto() {
        super();
    }

    public Produto(int id, Categoria categoria, String nome, double preco_unitario, double quantidade, int estoque, boolean descontinuado) {
        this();
        this.id = id;
        this.categoria = categoria;
        this.nome = nome;
        this.preco_unitario = preco_unitario;
        this.quantidade = quantidade;
        this.estoque = estoque;
        this.descontinuado = descontinuado;
    }

    public int getId() {
        return id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco_unitario() {
        return preco_unitario;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public int getEstoque() {
        return estoque;
    }

    public boolean isDescontinuado() {
        return descontinuado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco_unitario(double preco_unitario) {
        this.preco_unitario = preco_unitario;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public void setDescontinuado(boolean descontinuado) {
        this.descontinuado = descontinuado;
    }
    
    @Override
    public String toString() {
        return "Cliente{" 
                + "id=" + id 
                + ", categoria=" + categoria 
                + ", nome=" + nome
                + ", preco_unitario=" + preco_unitario
                + ", quantidade=" + quantidade
                + ", estoque=" + estoque 
                + ", descontinuado=" + descontinuado;
    } 
}
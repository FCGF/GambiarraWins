package br.org.catolicasc.cadastro.model;

public class Categoria extends Entity {

    private String nome;
    private String descricao;

    public Categoria() {
        super();
    }

    public Categoria(int id) {
        super(id);
    }

    public Categoria(int id, String nome, String descricao) {
        this(id);
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return String.format("Categoria: ID: %d, Nome: %s, Descrição: %s", id, nome, descricao);
    }

}

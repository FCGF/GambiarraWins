package br.org.catolicasc.model;

public class Cliente {
    
    private int id;
    private String nome;
    private boolean ativo;

    public Cliente() {
        super();
    }

    public Cliente(int id, String nome, boolean ativo) {
        this();
        this.id = id;
        this.nome = nome;
        this.ativo = ativo;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nome=" + nome + ", ativo=" + ativo + '}';
    } 
}


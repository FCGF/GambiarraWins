
package br.org.catolicasc.model;


public class Categoria {
    
    private int id;
    private String nome;
    private String descricao;

    public Categoria() {
        super();
    }

    public Categoria(int id) {
        this();
        this.id = id;
    }
    

    public Categoria(int id, String nome, String descricao) {
        this(id);
        
        this.nome = nome;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nome=" + nome + ", descricao=" + descricao + '}';
    } 
}

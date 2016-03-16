package br.org.catolicasc.cadastro.model;

/**
 *
 * @author fkannenberg
 */
public class Cliente extends Entity {

    private String nome;
    private boolean ativo;

    public Cliente() {
        super();
    }

    public Cliente(int id, String nome, boolean ativo) {
        super(id);
        this.nome = nome;
        this.ativo = ativo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void ativa() {
        this.ativo = true;
    }

    public void desativa() {
        this.ativo = false;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nome=" + nome + ", ativo=" + ativo + '}';
    }

}

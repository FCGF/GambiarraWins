package br.org.catolicasc.cadastro.model;

/**
 *
 * @author flavio.kannenberg
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

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return String.format("Cliente=[ ID: %d, Nome: %s, Ativo: %b ]", getId(), nome, ativo);
    }

}

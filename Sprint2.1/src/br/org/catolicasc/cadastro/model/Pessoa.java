
package br.org.catolicasc.cadastro.model;
import java.util.Date;
public abstract class Pessoa extends Entity {

    private String nome;
    private Date dataNascimento;

    public Pessoa() {
        super();
    }

    public Pessoa(int id) {
        super(id);
    }

    public Pessoa(String nome, Date dataNascimento, int id) {
        this(id);
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }
    
    public int calculaIdade(){
        return 2015 - dataNascimento.getYear();
    }

    @Override
    public String toString() {
        return "Nome: "+nome+" Data de nascimento: "+dataNascimento;
    }
    
    
}

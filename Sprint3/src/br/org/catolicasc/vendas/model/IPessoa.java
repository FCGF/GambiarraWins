
package br.org.catolicasc.vendas.model;

import java.util.Date;

/**
 *
 * @author flavio.kannenberg
 */
public interface IPessoa extends IEntity {

    int calculaIdade();

    Date getDataNascimento();

    String getNome();

    void setDataNascimento(Date dataNascimento);

    void setNome(String nome);
    
}

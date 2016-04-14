package br.org.catolicasc.vendas.model;

/**
 *
 * @author fkannenberg
 */
public interface IEntity {

    int getId();

    void setId(int id);
    
    boolean isTransient();

}

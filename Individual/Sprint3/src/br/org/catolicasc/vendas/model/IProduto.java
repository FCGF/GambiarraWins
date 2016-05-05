/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.vendas.model;

/**
 *
 * @author Cyber
 */
public interface IProduto extends IEntity {

    double calculaPesoEmQuilo();

    String getNome();

    double getPeso();

    double getQtdeDisponivel();

    UnidadePeso getUnidadePeso();

    void setNome(String nome);

    void setPeso(double peso);

    void setQtdeDisponivel(double qtdeDisponivel);

    void setUnidadePeso(UnidadePeso unidadePeso);

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.vendas.service;

import br.org.catolicasc.vendas.model.IEntity;
import java.util.List;

/**
 *
 * @author Cyber
 * @param <T>
 */
public interface IService<T extends IEntity>{
     int countAll() throws  Exception;

    void create(T o) throws  Exception;

    void delete(T o) throws  Exception;

    void deleteAll() throws Exception;

    List<T> findAll() throws  Exception;

    T findById(int id) throws  Exception;

    void update(T o) throws  Exception;
}

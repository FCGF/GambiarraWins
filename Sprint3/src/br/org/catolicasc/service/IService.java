
package br.org.catolicasc.service;

import br.org.catolicasc.vendas.model.IEntity;
import java.util.List;


public interface IService<T extends IEntity> {
    int countAll() throws Exception;

    void create(T o) throws Exception;

    void delete(T o) throws Exception;

    void deleteAll() throws Exception;

    List<T> findAll() throws Exception;

    T findById(int id) throws Exception;

    void update(T o) throws Exception;
}

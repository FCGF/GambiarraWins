package br.org.catolicasc.vendas.service;

import br.org.catolicasc.vendas.data.IDao;
import br.org.catolicasc.vendas.model.IEntity;
import java.util.List;

/**
 *
 * @author GambiarraWins
 * @param <T>
 * @param <K>
 */
public interface IService<T extends IEntity, K extends IDao<T>> {

    int countAll() throws Exception;

    void create(T o) throws Exception;

    void delete(T o) throws Exception;

    void deleteAll() throws Exception;

    List<T> findAll() throws Exception;

    T findById(int id) throws Exception;

    void update(T o) throws Exception;
    
    void createOrUpdate(T o) throws Exception;

}

package br.org.catolicasc.vendas.data;

import br.org.catolicasc.vendas.model.IEntity;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Cyber
 * @param <T>
 */
public interface IDao<T extends IEntity> {

    int countAll() throws SQLException, Exception;

    void create(T o) throws SQLException, Exception;

    void delete(T o) throws SQLException, Exception;

    void deleteAll() throws SQLException, Exception;

    List<T> findAll() throws SQLException, Exception;

    T findById(int id) throws SQLException, Exception;

    void update(T o) throws SQLException, Exception;

}

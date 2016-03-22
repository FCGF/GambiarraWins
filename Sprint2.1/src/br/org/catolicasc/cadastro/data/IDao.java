package br.org.catolicasc.cadastro.data;

import br.org.catolicasc.cadastro.model.IEntity;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author GambiarraWins
 * @param <T>
 */
public interface IDao<T extends IEntity> {

    public int countAll() throws SQLException, Exception;

    public void create(T o) throws SQLException, Exception;

    public void delete(T o) throws SQLException, Exception;

    public void deleteAll() throws SQLException, Exception;

    public List<T> findAll() throws SQLException, Exception;

    public IEntity findById(int id) throws SQLException, Exception;

    public void update(T o) throws SQLException, Exception;

}

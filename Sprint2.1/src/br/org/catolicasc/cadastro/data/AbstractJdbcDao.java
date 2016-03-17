package br.org.catolicasc.cadastro.data;

import br.org.catolicasc.cadastro.model.IEntity;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author GambiarraWins
 * @param <T>
 */
public abstract class AbstractJdbcDao<T extends IEntity> {

    private static final Logger LOGGER = LogManager.getLogger(AbstractJdbcDao.class);

    private ConnectionManager mngr = null;

    private static Type genericType;

    protected String findAllSql = null;
    protected String findByIdSql = null;
    protected String createSql = null;
    protected String updateSql = null;
    protected String deleteSql = null;
    protected String deleteAllSql = null;
    protected String countAllSql = null;

    public AbstractJdbcDao(ConnectionManager mngr) {
        super();
        this.mngr = mngr;

        Type sooper = getClass().getGenericSuperclass();
        genericType = ((ParameterizedType) sooper).getActualTypeArguments()[0];

    }

    public List<T> findAll() throws SQLException, Exception {
        List<T> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(findAllSql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                T o = fillObject(rs);
                lista.add(o);
            }
        } catch (SQLException ex) {
            LOGGER.error("Erro ao executar SQL (findAll)", ex);
            throw ex;
        } finally {
            close(conn);
            close(stmt);
            close(rs);
        }
        return lista;
    }

    public T findById(int id) throws SQLException, Exception {
        T o = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(findByIdSql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                o = fillObject(rs);
            }
        } catch (SQLException ex) {
            LOGGER.error("Erro ao executar SQL (findById)", ex);
            throw ex;
        } finally {
            close(conn);
            close(stmt);
            close(rs);
        }
        return o;
    }

    public void create(T o) throws SQLException, Exception {
        required(o);
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(createSql, PreparedStatement.RETURN_GENERATED_KEYS);
            bindingObject(stmt, o);
            stmt.executeUpdate();
            rs = stmt.getGeneratedKeys();
            while (rs.next()) {
                o.setId(rs.getInt(1));
            }
        } catch (SQLException ex) {
            LOGGER.error("Erro ao executar SQL (create)", ex);
            rollback(conn);
            throw ex;
        } finally {
            close(conn);
            close(stmt);
            close(rs);
        }
    }

    public void update(T o) throws SQLException, Exception {
        required(o);
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(updateSql, PreparedStatement.RETURN_GENERATED_KEYS);
            int idIndex = bindingObject(stmt, o);
            stmt.setInt(idIndex, o.getId());

            int rowcount = stmt.executeUpdate();
            if (rowcount == 0) {
                throw new SQLException("Objeto não salvo! (Chave primaria não encontrada!)");
            }
            if (rowcount > 1) {
                throw new SQLException("Erro de alteração de chave primária! (Mais de uma objeto afetado!)");
            }
        } catch (SQLException ex) {
            LOGGER.error("Erro ao executar SQL (update)", ex);
            rollback(conn);
            throw ex;
        } finally {
            close(conn);
            close(stmt);
            close(rs);
        }
    }

    public void delete(T o) throws SQLException, Exception {
        required(o);
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(deleteSql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, o.getId());
            int rowcount = stmt.executeUpdate();
            if (rowcount == 0) {
                throw new SQLException("Objeto não encontrado! (Chave primaria não encontrada!)");
            }
            if (rowcount > 1) {
                throw new SQLException("Erro de exclusão de chave primária! (Mais de uma objeto deletado!)");
            }
        } catch (SQLException ex) {
            LOGGER.error("Erro ao executar SQL (delete)", ex);
            rollback(conn);
            throw ex;
        } finally {
            close(conn);
            close(stmt);
            close(rs);
        }
    }

    public void deleteAll() throws SQLException, Exception {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(deleteAllSql);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            LOGGER.error("Erro ao executar SQL (deleteAll)", ex);
            rollback(conn);
            throw ex;
        } finally {
            close(conn);
            close(stmt);
        }
    }

    public int countAll() throws SQLException, Exception {
        Integer allRows = new Integer(0);
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(countAllSql);
            rs = stmt.executeQuery();
            if (rs.next()) {
                allRows = rs.getInt(1);
            }
        } catch (SQLException ex) {
            LOGGER.error("Erro ao executar SQL (countAll)", ex);
            throw ex;
        } finally {
            close(conn);
            close(stmt);
            close(rs);
        }
        return allRows;
    }

    protected abstract T fillObject(ResultSet rs) throws SQLException;

    protected abstract int bindingObject(PreparedStatement stmt, T o) throws SQLException;

    protected void rollback(Connection conn) throws SQLException {
        if (conn != null) {
            conn.rollback();
        }
    }

    protected void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                LOGGER.error("Erro ao fechar ResultSet.", ex);
            }
        }
    }

    protected void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                LOGGER.error("Erro ao fechar conexão.", ex);
            }
        }
    }

    protected void close(PreparedStatement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                LOGGER.error("Erro ao fechar objeto statement.", ex);
            }
        }
    }

    protected void required(T o) {
        if (o == null) {
            throw new NullPointerException("Entidade é requerida. Nome: " + genericType.getClass().getSimpleName());
        }
    }

    protected Connection getConnection() throws Exception {
        return mngr.getConnection();
    }

}

package br.org.catolicasc.cadastro.data;

import br.org.catolicasc.cadastro.model.Entity;
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
 * @author flavio.kannenberg
 * @param <T> Categoria, Cliente ou Produto.
 */
public abstract class AbstractJdbcDao<T extends Entity> {

    private static final Logger LOGGER = LogManager.getLogger(AbstractJdbcDao.class);
    private ConnectionManager mngr = null;

    protected String SQL_TO_FIND_ALL = null;
    protected String SQL_TO_FIND_BY_ID = null;
    protected String SQL_TO_CREATE = null;
    protected String SQL_TO_UPDATE = null;
    protected String SQL_TO_DELETE = null;
    protected String SQL_TO_DELETE_ALL = null;
    protected String SQL_TO_COUNT_ALL = null;

    public AbstractJdbcDao(ConnectionManager mngr) {
        super();
        this.mngr = mngr;
    }

    public List<T> findAll() throws SQLException, Exception {
        List<T> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_TO_FIND_ALL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                T o = fillObject(rs);
                lista.add(o);
            }
        } catch (SQLException ex) {
            LOGGER.error("Erro ao executar SQL (listAll)", ex);
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
            stmt = conn.prepareStatement(SQL_TO_FIND_BY_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                o = fillObject(rs);
            }
        } catch (SQLException ex) {
            LOGGER.error("Erro ao executar SQL (listById)", ex);
            throw ex;
        } finally {
            close(conn);
            close(stmt);
            close(rs);
        }
        return o;
    }

    public void create(T o) throws SQLException, Exception {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_TO_CREATE, PreparedStatement.RETURN_GENERATED_KEYS);
            bindingObject(stmt, o);
            stmt.executeUpdate();
            rs = stmt.getGeneratedKeys();
            while (rs.next()) {
                o.setId(rs.getInt(1));
            }
        } catch (SQLException ex) {
            LOGGER.error("Erro ao executar SQL (create)", ex);
            throw ex;
        } finally {
            close(conn);
            close(stmt);
            close(rs);
        }
    }

    public void update(T o) throws SQLException, Exception {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_TO_UPDATE, PreparedStatement.RETURN_GENERATED_KEYS);
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
            throw ex;
        } finally {
            close(conn);
            close(stmt);
            close(rs);
        }
    }

    public void delete(T o) throws SQLException, Exception {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_TO_DELETE, PreparedStatement.RETURN_GENERATED_KEYS);
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
            stmt = conn.prepareStatement(SQL_TO_DELETE_ALL);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            LOGGER.error("Erro ao executar SQL (deleteAll)", ex);
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
            stmt = conn.prepareStatement(SQL_TO_COUNT_ALL);
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

    /**
     *
     * @param rs ResultSet com os parâmetros a serem lidos.
     * @return Entidade preenchida com as informações lidas do ResultSet.
     * @throws SQLException
     */
    protected abstract T fillObject(ResultSet rs) throws SQLException;

    /**
     * @param stmt Statement para receber os parâmetros para preparar o SQL.
     * @param o Entidade da qual serão pegos os parâmetros.
     * @return Posição do índice dentro do SQL.
     * @throws SQLException
     */
    protected abstract int bindingObject(PreparedStatement stmt, T o) throws SQLException;

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

    protected Connection getConnection() throws Exception {
        return mngr.getConnection();
    }

}

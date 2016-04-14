package br.org.catolicasc.vendas.data;

import br.org.catolicasc.vendas.model.IEntity;
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
 * @author fkannenberg
 * @param <T>
 */
public abstract class AbstractJdbcDao<T extends IEntity> implements IDao<T> {

    private static final Logger LOGGER = LogManager.getLogger(AbstractJdbcDao.class);

    private final ConnectionManager mngr;
    private static Type genericType;

    public AbstractJdbcDao(ConnectionManager mngr) {
        super();
        this.mngr = mngr;

        Type sooper = getClass().getGenericSuperclass();
        genericType = ((ParameterizedType) sooper).getActualTypeArguments()[0];
    }

    protected String findAllSql = null;
    protected String findByIdSql = null;
    protected String createSql = null;
    protected String updateSql = null;
    protected String deleteSql = null;
    protected String deleteAllSql = null;
    protected String countAllSql = null;

    protected abstract T fillObject(ResultSet rs) throws SQLException;

    protected abstract int bindingObject(PreparedStatement stmt, T o) throws SQLException;

    @Override
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
                lista.add(fillObject(rs));
            }
        } catch (SQLException ex) {
            LOGGER.error("Erro ao executar SQL (listAll)", ex);
            throw ex;
        } finally {
            JdbcUtil.close(conn);
            JdbcUtil.close(stmt);
            JdbcUtil.close(rs);
        }

        return lista;
    }

    @Override
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
            LOGGER.error("Erro ao executar SQL (listById)", ex);
            throw ex;
        } finally {
            JdbcUtil.close(conn);
            JdbcUtil.close(stmt);
            JdbcUtil.close(rs);
        }

        return o;
    }

    @Override
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
            throw ex;
        } finally {
            JdbcUtil.close(conn);
            JdbcUtil.close(stmt);
            JdbcUtil.close(rs);
        }
    }

    @Override
    public void update(T o) throws SQLException, Exception {
        required(o);
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(updateSql, PreparedStatement.RETURN_GENERATED_KEYS);

            int parameterIndex = bindingObject(stmt, o);
            stmt.setInt(parameterIndex, o.getId());

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
            JdbcUtil.close(conn);
            JdbcUtil.close(stmt);
            JdbcUtil.close(rs);
        }
    }

    @Override
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
            throw ex;
        } finally {
            JdbcUtil.close(conn);
            JdbcUtil.close(stmt);
            JdbcUtil.close(rs);
        }
    }

    @Override
    public void deleteAll() throws SQLException, Exception {

        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(deleteAllSql);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            LOGGER.error("Erro ao executar SQL (deleteAll)", ex);
            throw ex;
        } finally {
            JdbcUtil.close(conn);
            JdbcUtil.close(stmt);
        }
    }

    @Override
    public int countAll() throws SQLException, Exception {

        Integer allRows = 0;

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
            JdbcUtil.close(conn);
            JdbcUtil.close(stmt);
            JdbcUtil.close(rs);
        }

        return allRows;
    }

    protected void required(T o) {
        if (o == null) {
            throw new NullPointerException("Entidade é requerida. Nome: " + genericType.getClass().getSimpleName());
        }
    }

    protected List<T> executeQuery(String sql, Object... parameters) throws SQLException, Exception {
        List<T> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(sql);

            if (parameters != null && parameters.length > 0) {
                for (int i = 0; i < parameters.length; i++) {
                    Object obj = parameters[i];
                    int parameterIndex = (i + 1);

                    if (obj instanceof String) {
                        stmt.setString(parameterIndex, (String) obj);
                    } else if (obj instanceof Integer) {
                        stmt.setInt(parameterIndex, (Integer) obj);
                    } else if (obj instanceof Double) {
                        stmt.setDouble(parameterIndex, (Double) obj);
                    } else if (obj instanceof Boolean) {
                        stmt.setBoolean(parameterIndex, (Boolean) obj);
                    } else if (obj instanceof Float) {
                        stmt.setFloat(parameterIndex, (Float) obj);
                    }
                }
            }

            rs = stmt.executeQuery();
            while (rs.next()) {
                T o = fillObject(rs);
                lista.add(o);
            }

        } catch (SQLException ex) {
            LOGGER.error("Erro ao executar SQL [ " + sql + " ]", ex);
            throw ex;
        } finally {
            JdbcUtil.close(conn);
            JdbcUtil.close(stmt);
            JdbcUtil.close(rs);
        }
        return lista;
    }

    private Connection getConnection() throws Exception {
        return mngr.getConnection();
    }
}

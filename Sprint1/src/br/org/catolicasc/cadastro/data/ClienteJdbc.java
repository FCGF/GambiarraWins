package br.org.catolicasc.cadastro.data;

import br.org.catolicasc.cadastro.model.Cliente;
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
 */
public class ClienteJdbc {

    private static final Logger LOGGER = LogManager.getLogger(ClienteJdbc.class);
    private final ConnectionManager mngr;

    public ClienteJdbc(ConnectionManager mngr) {
        super();
        this.mngr = mngr;
    }

    // Listar TODOS os clientes cadastrados
    public List<Cliente> findAll() throws SQLException, Exception {

        final String SQL_TO_FIND_ALL = "SELECT id, nome, ativo FROM cliente";

        List<Cliente> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_TO_FIND_ALL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente o = new Cliente();
                o.setId(rs.getInt("id"));
                o.setNome(rs.getString("nome"));
                o.setAtivo(rs.getBoolean("ativo"));
                lista.add(o);
            }
        } catch (SQLException ex) {
            LOGGER.error("Erro ao executar SQL (listAll)", ex);
            throw ex;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    LOGGER.error("Erro ao fechar conexão.", ex);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    LOGGER.error("Erro ao fechar objeto statement.", ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    LOGGER.error("Erro ao fechar ResultSet.", ex);
                }
            }
        }

        return lista;
    }

    // Buscar o cliente pelo seu código
    public Cliente findById(int id) throws SQLException, Exception {

        final String SQL_TO_FIND_BY_ID = "SELECT id, nome, ativo FROM cliente WHERE id = ?";

        Cliente o = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_TO_FIND_BY_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                o = new Cliente();
                o.setId(rs.getInt("id"));
                o.setNome(rs.getString("nome"));
                o.setAtivo(rs.getBoolean("ativo"));
            }
        } catch (SQLException ex) {
            LOGGER.error("Erro ao executar SQL (listById)", ex);
            throw ex;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    LOGGER.error("Erro ao fechar conexão.", ex);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    LOGGER.error("Erro ao fechar objeto statement.", ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    LOGGER.error("Erro ao fechar ResultSet.", ex);
                }
            }
        }

        return o;
    }

    // Criar/Gravar um cliente novo
    public void create(Cliente o) throws SQLException, Exception {

        final String SQL_TO_CREATE = "INSERT INTO cliente (nome, ativo) VALUES (?, ?)";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_TO_CREATE, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, o.getNome());
            stmt.setBoolean(2, o.isAtivo());
            stmt.executeUpdate();

            rs = stmt.getGeneratedKeys();
            while (rs.next()) {
                o.setId(rs.getInt(1));
            }
        } catch (SQLException ex) {
            LOGGER.error("Erro ao executar SQL (create)", ex);
            throw ex;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    LOGGER.error("Erro ao fechar conexão.", ex);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    LOGGER.error("Erro ao fechar objeto statement.", ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    LOGGER.error("Erro ao fechar ResultSet.", ex);
                }
            }
        }
    }

    // Altera os dados do cliente.
    public void update(Cliente o) throws SQLException, Exception {

        final String SQL_TO_UPDATE = "UPDATE cliente SET nome=?, ativo=? WHERE (id=?)";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_TO_UPDATE, PreparedStatement.RETURN_GENERATED_KEYS);

            stmt.setString(1, o.getNome());
            stmt.setBoolean(2, o.isAtivo());
            stmt.setInt(3, o.getId());

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
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    LOGGER.error("Erro ao fechar conexão.", ex);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    LOGGER.error("Erro ao fechar objeto statement.", ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    LOGGER.error("Erro ao fechar ResultSet.", ex);
                }
            }
        }
    }

    // Exclui o cliente
    public void delete(Cliente o) throws SQLException, Exception {

        final String SQL_TO_DELETE = "DELETE FROM cliente WHERE (id=?)";

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
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    LOGGER.error("Erro ao fechar conexão.", ex);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    LOGGER.error("Erro ao fechar objeto statement.", ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    LOGGER.error("Erro ao fechar ResultSet.", ex);
                }
            }
        }
    }

    // Exclui todos os clientes
    public void deleteAll() throws SQLException, Exception {

        final String SQL_TO_DELETE_ALL = "DELETE FROM cliente";

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
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    LOGGER.error("Erro ao fechar conexão.", ex);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    LOGGER.error("Erro ao fechar objeto statement.", ex);
                }
            }
        }
    }

    public int countAll() throws SQLException, Exception {

        final String SQL_TO_COUNT_ALL = "SELECT COUNT(1) FROM cliente";

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
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    LOGGER.error("Erro ao fechar conexão.", ex);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    LOGGER.error("Erro ao fechar objeto statement.", ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    LOGGER.error("Erro ao fechar ResultSet.", ex);
                }
            }
        }

        return allRows;
    }

    private Connection getConnection() throws Exception {
        return mngr.getConnection();
    }
}

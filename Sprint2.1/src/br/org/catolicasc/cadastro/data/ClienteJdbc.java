package br.org.catolicasc.cadastro.data;

import br.org.catolicasc.cadastro.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author GambiarraWins
 */
public final class ClienteJdbc extends AbstractJdbcDao<Cliente> {
    
    private final String findByNameSql;
    
    public ClienteJdbc(ConnectionManager mngr) {
        super(mngr);
        
        findAllSql = "SELECT ID, NOME, DATA_NASCIMENTO, LIMITE_CREDITO, NUMERO_CARTAO, CONTATO, ATIVO FROM CLIENTE";
        findByIdSql = "SELECT ID, NOME, DATA_NASCIMENTO, LIMITE_CREDITO, NUMERO_CARTAO, CONTATO, ATIVO FROM CLIENTE WHERE (ID=?)";
        findByNameSql = "SELECT ID, NOME, DATA_NASCIMENTO, LIMITE_CREDITO, NUMERO_CARTAO, CONTATO, ATIVO FROM CLIENTE WHERE (NOME LIKE ?)";
        createSql = "INSERT INTO CLIENTE (NOME, DATA_NASCIMENTO, LIMITE_CREDITO, NUMERO_CARTAO, CONTATO, ATIVO) VALUES (?, ?, ?, ?, ?, ?)";
        updateSql = "UPDATE CLIENTE SET NOME=?, DATA_NASCIMENTO=?, LIMITE_CREDITO=?, NUMERO_CARTAO=?, CONTATO=?, ATIVO=? WHERE (ID=?)";
        deleteSql = "DELETE FROM CLIENTE WHERE (ID=?)";
        deleteAllSql = "DELETE FROM CLIENTE";
        countAllSql = "SELECT COUNT(1) FROM CLIENTE";

    }
    
    public Cliente findByName(String nome) throws SQLException, Exception {
        Cliente o = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(findByNameSql);
            stmt.setString(1, nome);
            rs = stmt.executeQuery();
            while (rs.next()) {
                o = fillObject(rs);
            }
        } catch (SQLException ex) {
            LOGGER.error("Erro ao executar SQL (findByName)", ex);
            throw ex;
        } finally {
            close(conn);
            close(stmt);
            close(rs);
        }
        return o;
    }

    @Override
    protected Cliente fillObject(ResultSet rs) throws SQLException {

        Cliente o = new Cliente();

        o.setId(rs.getInt("id"));
        o.setNome(rs.getString("nome"));
        o.setAtivo(rs.getBoolean("ativo"));

        return o;
    }

    @Override
    protected int bindingObject(PreparedStatement stmt, Cliente o) throws SQLException {
        stmt.setString(1, o.getNome());
        stmt.setBoolean(2, o.isAtivo());
        return 3;
    }
}

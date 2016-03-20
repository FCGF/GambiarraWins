package br.org.catolicasc.cadastro.data;

import br.org.catolicasc.cadastro.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
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
        o.setId(rs.getInt("ID"));
        o.setNome(rs.getString("NOME"));
        o.setDataNascimento(rs.getDate("DATA_NASCIMENTO"));
        o.setLimiteCredito(rs.getDouble("LIMITE_CREDITO"));
        o.setNumeroCartaoCredito(rs.getDouble("NUMERO_CARTAO"));
        o.setContato(rs.getString("CONTATO"));
        o.setAtivo(rs.getBoolean("ATIVO"));
        return o;
    }

    @Override
    protected int bindingObject(PreparedStatement stmt, Cliente o) throws SQLException {
        stmt.setString(1, o.getNome());
        stmt.setDate(2, new java.sql.Date(o.getDataNascimento().getTime()));
        stmt.setDouble(3, o.getLimiteCredito());
        stmt.setDouble(4, o.getNumeroCartaoCredito());
        stmt.setString(5, o.getContato());
        stmt.setBoolean(6, o.isAtivo());
        return 7;
    }
}

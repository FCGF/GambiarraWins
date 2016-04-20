package br.org.catolicasc.vendas.data;

import br.org.catolicasc.vendas.model.Cliente;
import br.org.catolicasc.vendas.model.ICliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Cyber
 */
public final class ClienteJdbc extends AbstractJdbcDao<ICliente> implements IClienteJdbc {

    private final String findByNameSql = "SELECT * FROM CLIENTE WHERE (NOME LIKE ?)";
    
    public ClienteJdbc(ConnectionManager mngr) {
        super(mngr);

        findAllSql = "SELECT * FROM CLIENTE";
        findByIdSql = "SELECT * FROM CLIENTE WHERE (ID=?)";
        createSql = "INSERT INTO CLIENTE (NOME, DATA_NASCIMENTO, LIMITE_CREDITO, NUMERO_CARTAO, CONTATO, ATIVO) VALUES (?, ?, ?, ?, ?, ?)";
        updateSql = "UPDATE CLIENTE SET NOME=?, DATA_NASCIMENTO=?, LIMITE_CREDITO=?, NUMERO_CARTAO=?, CONTATO=?, ATIVO=? WHERE (ID=?)";
        deleteSql = "DELETE FROM CLIENTE WHERE (ID=?)";
        deleteAllSql = "DELETE FROM CLIENTE";
        countAllSql = "SELECT COUNT(1) FROM CLIENTE";

    }
    
    @Override
    public List<ICliente> findByNome(String nome) throws SQLException, Exception {
        return executeQuery(findByNameSql, nome);
    }

    @Override
    protected ICliente fillObject(ResultSet rs) throws SQLException {
        ICliente o = new Cliente();
        o.setId(rs.getInt("ID"));
        o.setNome(rs.getString("NOME"));

        Timestamp time = rs.getTimestamp("DATA_NASCIMENTO");
        o.setDataNascimento(new Date(time.getTime()));

        o.setLimiteCredito(rs.getDouble("LIMITE_CREDITO"));
        o.setNumeroCartaoCredito(rs.getInt("NUMERO_CARTAO"));
        o.setContato(rs.getString("CONTATO"));
        o.setAtivo(rs.getBoolean("ATIVO"));
        return o;
    }

    @Override
    protected int bindingObject(PreparedStatement stmt, ICliente o) throws SQLException {
        int parameterIndex = 1;
        ICliente c = (Cliente) o;
        stmt.setString(parameterIndex++, c.getNome());
        stmt.setDate(parameterIndex++, new java.sql.Date(c.getDataNascimento().getTime()));
        stmt.setDouble(parameterIndex++, c.getLimiteCredito());
        stmt.setInt(parameterIndex++, c.getNumeroCartaoCredito());
        stmt.setString(parameterIndex++, c.getContato());
        stmt.setBoolean(parameterIndex++, c.isAtivo());
        return parameterIndex;
    }
}

package br.org.catolicasc.cadastro.data;

import br.org.catolicasc.cadastro.model.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author flavio.kannenberg
 */
public final class ClienteJdbc extends AbstractJdbcDao<Cliente> {

    public ClienteJdbc(ConnectionManager mngr) {
        super(mngr);

        findAllSql = "SELECT id, nome, ativo FROM cliente";
        findByIdSql = "SELECT id, nome, ativo FROM cliente WHERE id = ?";
        createSql = "INSERT INTO cliente (nome, ativo) VALUES (?, ?)";
        updateSql = "UPDATE cliente SET nome=?, ativo=? WHERE (id=?)";
        deleteSql = "DELETE FROM cliente WHERE (id=?)";
        deleteAllSql = "DELETE FROM cliente";
        countAllSql = "SELECT COUNT(1) FROM cliente";

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

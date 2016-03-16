package br.org.catolicasc.cadastro.data;

import br.org.catolicasc.cadastro.model.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteJdbc extends AbstractJdbcDao<Cliente> {

    public ClienteJdbc(ConnectionManager mngr) {
        super(mngr);

        SQL_TO_FIND_ALL = "SELECT id, nome, ativo FROM cliente";
        SQL_TO_FIND_BY_ID = "SELECT id, nome, ativo FROM cliente WHERE id = ?";
        SQL_TO_CREATE = "INSERT INTO cliente (nome, ativo) VALUES (?, ?)";
        SQL_TO_UPDATE = "UPDATE cliente SET nome=?, ativo=? WHERE (id=?)";
        SQL_TO_DELETE = "DELETE FROM cliente WHERE (id=?)";
        SQL_TO_DELETE_ALL = "DELETE FROM cliente";
        SQL_TO_COUNT_ALL = "SELECT COUNT(1) FROM cliente";
    }

    @Override
    protected Cliente fillObject(ResultSet rs) throws SQLException {
        Cliente o = new Cliente();
        o.setId(rs.getInt("id"));
        o.setNome(rs.getString("nome"));
        if (rs.getBoolean("ativo")) {
            o.ativa();
        } else {
            o.desativa();
        }
        return o;
    }

    @Override
    protected int bindingObject(PreparedStatement stmt, Cliente o) throws SQLException {
        stmt.setString(1, o.getNome());
        stmt.setBoolean(2, o.isAtivo());
        return 3;
    }
}

package br.org.catolicasc.vendas.data;

import br.org.catolicasc.vendas.model.Cliente;
import br.org.catolicasc.vendas.model.Pedido;
import br.org.catolicasc.vendas.model.StatusPedido;
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
public final class PedidoJdbc extends AbstractJdbcDao<Pedido> {

    private final String findByVendedorSql = "SELECT * FROM PEDIDO WHERE (NOME_VENDEDOR LIKE ?)";

    public PedidoJdbc(ConnectionManager mngr) {
        super(mngr);

        findAllSql = "SELECT * FROM PEDIDO";
        findByIdSql = "SELECT * FROM PEDIDO WHERE (ID=?)";
        createSql = "INSERT INTO PEDIDO (CLIENTE_ID, DATA_PEDIDO, NOME_VENDEDOR, OBSERVACAO, STATUS_PEDIDO) VALUES (?, ?, ?, ?, ?)";
        updateSql = "UPDATE PEDIDO SET CLIENTE_ID=?, DATA_PEDIDO=?, NOME_VENDEDOR=?, OBSERVACAO=?, STATUS_PEDIDO=? WHERE (ID=?)";
        deleteSql = "DELETE FROM PEDIDO WHERE (ID=?)";
        deleteAllSql = "DELETE FROM PEDIDO";
        countAllSql = "SELECT COUNT(1) FROM PEDIDO";

    }

    public List<Pedido> findByVendedor(String nome) throws SQLException, Exception {
        return executeQuery(findByVendedorSql, nome);
    }

    @Override
    protected Pedido fillObject(ResultSet rs) throws SQLException {
        Pedido o = new Pedido();
        o.setId(rs.getInt("ID"));

        Cliente c = new Cliente();
        c.setId(rs.getInt("CLIENTE_ID"));
        o.setCliente(c);

        Timestamp time = rs.getTimestamp("DATA_PEDIDO");
        o.setData(new Date(time.getTime()));

        o.setVendedor(rs.getString("NOME_VENDEDOR"));
        o.setObservacao(rs.getString("OBSERVACAO"));
        o.setStatusPedido(StatusPedido.valueOf(rs.getString("STATUS_PEDIDO")));

        return o;
    }

    @Override
    protected int bindingObject(PreparedStatement stmt, Pedido o) throws SQLException {
        int parameterIndex = 1;
        Pedido p = (Pedido) o;
        stmt.setInt(parameterIndex++, p.getCliente().getId());
        stmt.setDate(parameterIndex++, new java.sql.Date(p.getData().getTime()));
        stmt.setString(parameterIndex++, p.getVendedor());
        stmt.setString(parameterIndex++, p.getObservacao());
        stmt.setString(parameterIndex++, p.getStatusPedido().toString());
        return parameterIndex;
    }

}

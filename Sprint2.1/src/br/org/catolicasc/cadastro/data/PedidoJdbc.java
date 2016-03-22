package br.org.catolicasc.cadastro.data;

import br.org.catolicasc.cadastro.model.Pedido;
import br.org.catolicasc.cadastro.model.StatusPedido;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author GambiarraWins
 */
public class PedidoJdbc extends AbstractJdbcDao<Pedido> {

    public PedidoJdbc(ConnectionManager mngr) {
        super(mngr);

        findAllSql = "SELECT ID, CLIENTE_ID, DATA_PEDIDO, NOME_VENDEDOR, OBSERVACAO, STATUS_PEDIDO FROM PEDIDO";
        findByIdSql = "SELECT ID, CLIENTE_ID, DATA_PEDIDO, NOME_VENDEDOR, OBSERVACAO, STATUS_PEDIDO FROM PEDIDO WHERE (ID = ?)";
        createSql = "INSERT INTO PEDIDO (CLIENTE_ID, DATA_PEDIDO, NOME_VENDEDOR, OBSERVACAO, STATUS_PEDIDO) VALUES (?, ?, ?, ?, ?)";
        updateSql = "UPDATE PEDIDO SET CLIENTE_ID=?, DATA_PEDIDO=?, NOME_VENDEDOR=?, OBSERVACAO=?, STATUS_PEDIDO=? WHERE (ID=?)";
        deleteSql = "DELETE FROM PEDIDO WHERE (ID=?)";
        deleteAllSql = "DELETE FROM PEDIDO";
        countAllSql = "SELECT COUNT(1) FROM PEDIDO";
    }

    @Override
    protected Pedido fillObject(ResultSet rs) throws SQLException, Exception {
        Pedido o = new Pedido();

        o.setId(rs.getInt("ID"));
        long time = rs.getDate("DATA_PEDIDO").getTime();
        o.setData(new Date(time));
        o.setVendedor(rs.getString("NOME_VENDEDOR"));
        o.setObservacao(rs.getString("OBSERVACAO"));
        o.setStatusPedido(StatusPedido.valueOf(rs.getString("STATUS_PEDIDO")));
//        int idCliente = rs.getInt("CLIENTE_ID");
//        ClienteJdbc clienteJdbc = new ClienteJdbc(ConnectionManager.getInstance());
//        Cliente cliente = clienteJdbc.findById(idCliente);
//        o.setCliente(cliente);
        return o;
    }

    @Override
    protected int bindingObject(PreparedStatement stmt, Pedido o) throws SQLException, Exception {
        stmt.setInt(1, o.getCliente().getId());
        stmt.setDate(2, new java.sql.Date(o.getData().getTime()));
        stmt.setString(3, o.getVendedor());
        stmt.setString(4, o.getObservacao());
        stmt.setString(5, o.getStatusPedido().name());

        return 6;
    }

}

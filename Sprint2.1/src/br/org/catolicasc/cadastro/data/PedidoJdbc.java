package br.org.catolicasc.cadastro.data;

import br.org.catolicasc.cadastro.model.Cliente;
import br.org.catolicasc.cadastro.model.ItemPedido;
import br.org.catolicasc.cadastro.model.Pedido;
import br.org.catolicasc.cadastro.model.StatusPedido;
import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author GambiarraWins
 */
public class PedidoJdbc extends AbstractJdbcDao<Pedido> {

    public PedidoJdbc(ConnectionManager mngr) {
        super(mngr);

        findAllSql = "SELECT ID, CLIENTE_ID, DATA_PEDIDO, NOME_VENDEDOR, OBSERVACAO, STATUS_PEDIDO FROM PEDIDO";
        findByIdSql = "SELECT ID, CLIENTE_ID, DATA_PEDIDO, NOME_VENDEDOR, OBSERVACAO, STATUS_PEDIDO FROM PEDIDO FROM PEDIDO WHERE (ID=?)";
        createSql = "INSERT INTO PEDIDO (CLIENTE_ID, DATA_PEDIDO, NOME_VENDEDOR, OBSERVACAO, STATUS_PEDIDO) VALUES (?, ?, ?, ?, ?)";
        updateSql = "UPDATE PEDIDO SET CLIENTE_ID=?, DATA_PEDIDO=?, NOME_VENDEDOR=?, OBSERVACAO=?, STATUS_PEDIDO=? WHERE (ID=?)";
        deleteSql = "DELETE FROM PEDIDO WHERE (ID=?)";
        deleteAllSql = "DELETE FROM PEDIDO";
        countAllSql = "SELECT COUNT(1) FROM PEDIDO";
    }

    @Override
    protected Pedido fillObject(ResultSet rs) throws SQLException {
        Pedido o = new Pedido();
        Cliente cliente = new Cliente();
        Date data  = new Date();
        List<ItemPedido> itens =  new ArrayList<>();
        
        o.setId(rs.getInt("id"));
        o.setVendedor(rs.getString("vendedor"));
        o.setCliente(cliente);     
        o.setData(data);
        o.setStatusPedido(StatusPedido.FATURADO);

        return o;
    }

    @Override
    protected int bindingObject(PreparedStatement stmt, Pedido o) throws SQLException {
        Cliente cliente = new Cliente();
        Date data  = new Date();
        List<ItemPedido> itens =  new ArrayList<>();
        StatusPedido statusPedido;
        statusPedido = StatusPedido.CANCELADO;
        String pedido = statusPedido.toString();
        
        
        stmt.setString(1, o.getVendedor());
        stmt.setString(2, o.getObservacao());
        stmt.setObject(3, cliente);
        stmt.setDate(4, (java.sql.Date) o.getData());
        stmt.setArray(5, (Array) o.getItens());
        stmt.setString(6, pedido);
        
        return 7;
    }

}

package br.org.catolicasc.vendas.data;

import br.org.catolicasc.vendas.model.ItemPedido;
import br.org.catolicasc.vendas.model.Pedido;
import br.org.catolicasc.vendas.model.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author fkannenberg
 */
public final class ItemPedidoJdbc extends AbstractJdbcDao<ItemPedido> {

    private final String findByPedidoSql = "SELECT * FROM ITEM_PEDIDO WHERE (PEDIDO_ID = ?)";
    private final String findByPedidoAndProdutoSql = "SELECT * FROM ITEM_PEDIDO WHERE (PEDIDO_ID = ?) AND (PRODUTO_ID = ?)";

    public ItemPedidoJdbc(ConnectionManager mngr) {
        super(mngr);

        findAllSql = "SELECT * FROM ITEM_PEDIDO";
        findByIdSql = "SELECT * FROM ITEM_PEDIDO WHERE (ID=?)";
        createSql = "INSERT INTO ITEM_PEDIDO (PRODUTO_ID, PEDIDO_ID, QUANTIDADE, PRECO) VALUES (?, ?, ?, ?)";
        updateSql = "UPDATE ITEM_PEDIDO SET PRODUTO_ID=?, PEDIDO_ID=?, QUANTIDADE=?, PRECO=? WHERE (ID=?)";
        deleteSql = "DELETE FROM ITEM_PEDIDO WHERE (ID=?)";
        deleteAllSql = "DELETE FROM ITEM_PEDIDO";
        countAllSql = "SELECT COUNT(1) FROM ITEM_PEDIDO";

    }

    public List<ItemPedido> findByPedido(int pedidoId) throws SQLException, Exception {
        return executeQuery(findByPedidoSql, pedidoId);
    }

    public List<ItemPedido> findByPedidoAndProduto(int pedidoId, int produtoId) throws SQLException, Exception {
        return executeQuery(findByPedidoAndProdutoSql, pedidoId, produtoId);
    }

    @Override
    protected ItemPedido fillObject(ResultSet rs) throws SQLException {
        ItemPedido o = new ItemPedido();
        o.setId(rs.getInt("ID"));

        Produto produto = new Produto();
        produto.setId(rs.getInt("PRODUTO_ID"));
        o.setProduto(produto);

        Pedido pedido = new Pedido();
        pedido.setId(rs.getInt("PEDIDO_ID"));
        o.setPedido(pedido);

        int quantidade = rs.getInt("QUANTIDADE");
        double preco = rs.getDouble("PRECO");

        o.setQuantidade(quantidade);
        o.setPreco(preco);

        return o;
    }

    @Override
    protected int bindingObject(PreparedStatement stmt, ItemPedido o) throws SQLException {
        int parameterIndex = 1;
        stmt.setInt(parameterIndex++, o.getProduto().getId());
        stmt.setInt(parameterIndex++, o.getPedido().getId());
        stmt.setInt(parameterIndex++, o.getQuantidade());
        stmt.setDouble(parameterIndex++, o.getPreco());
        return parameterIndex;
    }

}

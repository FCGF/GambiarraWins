package br.org.catolicasc.cadastro.data;

import br.org.catolicasc.cadastro.model.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author flavio.kannenberg
 */
public class PedidoJdbc extends AbstractJdbcDao<Produto> {

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
    protected int bindingObject(PreparedStatement stmt, Produto o) throws SQLException {
        Produto p = (Produto) o;
        stmt.setString(2, p.getNome());
        return 7;
    }

    @Override
    protected Produto fillObject(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}

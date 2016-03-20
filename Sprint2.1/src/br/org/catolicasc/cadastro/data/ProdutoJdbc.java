package br.org.catolicasc.cadastro.data;

import br.org.catolicasc.cadastro.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author GambiarraWins
 */
public class ProdutoJdbc extends AbstractJdbcDao<Produto> {

    private final String findByNameSql;

    public ProdutoJdbc(ConnectionManager mngr) {
        super(mngr);

        findAllSql = "SELECT ID, NOME, PESO, QTDE_DISPONIVEL, UNIDADE_PESO FROM PRODUTO";
        findByIdSql = "SELECT ID, NOME, PESO, QTDE_DISPONIVEL, UNIDADE_PESO FROM PRODUTO WHERE (ID=?)";
        findByNameSql = "SELECT ID, NOME, PESO, QTDE_DISPONIVEL, UNIDADE_PESO FROM PRODUTO WHERE (NOME LIKE ?) ";
        createSql = "INSERT INTO PRODUTO (NOME, PESO, QTDE_DISPONIVEL, UNIDADE_PESO) VALUES (?, ?, ?, ?)";
        updateSql = "UPDATE PRODUTO SET NOME=?, PESO=?, QTDE_DISPONIVEL=?, UNIDADE_PESO=? WHERE (ID=?)";
        deleteSql = "DELETE FROM produto WHERE (id=?)";
        deleteAllSql = "DELETE FROM produto";
        countAllSql = "SELECT COUNT(1) FROM produto";
    }

    @Override
    protected Produto fillObject(ResultSet rs) throws SQLException {
        Produto o = new Produto();
        o.setId(rs.getInt("ID"));
        o.setNome(rs.getString("NOME"));
        o.setPeso(rs.getDouble("PESO"));
        o.setQtdeDisponivel(rs.getDouble("QTDE_DISPONIVEL"));
        o.setUnidade(rs.getInt("UNIDADE_PESO"));
        return o;
    }

    @Override
    protected int bindingObject(PreparedStatement stmt, Produto o) throws SQLException {
//        Produto p = (Produto) o;
        stmt.setString(1, o.getNome());
        stmt.setDouble(2, o.getPeso());
        stmt.setDouble(3, o.getQtdeDisponivel());
        stmt.setString(4, o.getUnidade().name());
        return 5;
    }

    public Produto findByName(String name) throws SQLException, Exception {
        Produto o = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(findByNameSql);
            stmt.setString(1, name);
            rs = stmt.executeQuery();
            while (rs.next()) {
                o = fillObject(rs);
            }
        } catch (SQLException ex) {
            LOGGER.error("Erro ao executar SQL (listByName)", ex);
            throw ex;
        } finally {
            close(conn);
            close(stmt);
            close(rs);
        }
        return o;
    }
}

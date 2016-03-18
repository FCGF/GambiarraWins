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
        createSql = "INSERT INTO PRODUTO (NOME, PESO, QTDE_DISPONIVEL, UNIDADE_PESO) VALUES (?, ?, ?, ?)";
        updateSql = "UPDATE PRODUTO SET NOME=?, PESO=?, QTDE_DISPONIVEL=?, UNIDADE_PESO=? WHERE (ID=?)";
        deleteSql = "DELETE FROM produto WHERE (id=?)";
        deleteAllSql = "DELETE FROM produto";
        countAllSql = "SELECT COUNT(1) FROM produto";
        findByNameSql = "SELECT ID, NOME, PESO, QTDE_DISPONIVEL, UNIDADE_PESO FROM PRODUTO WHERE (NOME LIKE ?) ";

    }

    @Override
    protected Produto fillObject(ResultSet rs) throws SQLException {
        Produto o = new Produto();
        o.setId(rs.getInt("id"));
        o.setNome(rs.getString("nome"));
        o.setPeso(rs.getDouble("peso"));
        o.setQtdeDisponivel(rs.getDouble("quantidade Disponivel"));
        o.setUnidade(rs.getInt("indice"));

        return o;
    }

    @Override
    protected int bindingObject(PreparedStatement stmt, Produto o) throws SQLException {
        Produto p = (Produto) o;
        stmt.setInt(1, p.getId());
        stmt.setString(2, p.getNome());
        stmt.setDouble(3, p.getPeso());
        stmt.setDouble(4, p.getQtdeDisponivel());

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

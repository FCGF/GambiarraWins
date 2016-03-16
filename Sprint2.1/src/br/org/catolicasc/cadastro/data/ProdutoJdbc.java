package br.org.catolicasc.cadastro.data;

import br.org.catolicasc.cadastro.model.Categoria;
import br.org.catolicasc.cadastro.model.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author flavio.kannenberg
 */
public class ProdutoJdbc extends AbstractJdbcDao<Produto> {

    public ProdutoJdbc(ConnectionManager mngr) {
        super(mngr);

        findAllSql = "SELECT id, categoria_id, nome, preco_unitario, quantidade, estoque, descontinuado FROM produto";
        findByIdSql = "SELECT id, categoria_id, nome, preco_unitario, quantidade, estoque, descontinuado FROM produto WHERE id = ?";
        createSql = "INSERT INTO produto (categoria_id, nome, preco_unitario, quantidade, estoque, descontinuado) VALUES (?, ?, ?, ?, ?, ?)";
        updateSql = "UPDATE produto SET categoria_id=?, nome=?, preco_unitario=?, quantidade=?, estoque=?, descontinuado=? WHERE (id=?)";
        deleteSql = "DELETE FROM produto WHERE (id=?)";
        deleteAllSql = "DELETE FROM produto";
        countAllSql = "SELECT COUNT(1) FROM produto";

    }

    @Override
    protected Produto fillObject(ResultSet rs) throws SQLException {
        Produto o = new Produto();
        o.setId(rs.getInt("id"));
        o.setCategoria(new Categoria(rs.getInt("categoria_id")));
        o.setNome(rs.getString("nome"));
        o.setPrecoUnitario(rs.getDouble("preco_unitario"));
        o.setQuantidade(rs.getDouble("quantidade"));
        o.setEstoque(rs.getInt("estoque"));
        o.continua();
        if (rs.getBoolean("descontinuado")) {
            o.descontinua();
        }
        return o;
    }

    @Override
    protected int bindingObject(PreparedStatement stmt, Produto o) throws SQLException {
        Produto p = (Produto) o;
        stmt.setInt(1, p.getCategoria().getId());
        stmt.setString(2, p.getNome());
        stmt.setDouble(3, p.getPrecoUnitario());
        stmt.setDouble(4, p.getQuantidade());
        stmt.setInt(5, p.getEstoque());
        stmt.setBoolean(6, p.isDescontinuado());
        return 7;
    }

}

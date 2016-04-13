package br.org.catolicasc.vendas.data;

import br.org.catolicasc.vendas.model.Produto;
import br.org.catolicasc.vendas.model.UnidadePeso;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author fkannenberg
 */
public final class ProdutoJdbc extends AbstractJdbcDao<Produto> {

    private final String findByNameSql = "SELECT * FROM PRODUTO WHERE (nome LIKE ?)";

    public ProdutoJdbc(ConnectionManager mngr) {
        super(mngr);

        findAllSql = "SELECT * FROM PRODUTO";
        findByIdSql = "SELECT * FROM PRODUTO WHERE (ID=?)";
        createSql = "INSERT INTO PRODUTO (NOME, PESO, QTDE_DISPONIVEL, UNIDADE_PESO) VALUES (?, ?, ?, ?)";
        updateSql = "UPDATE PRODUTO SET NOME=?, PESO=?, QTDE_DISPONIVEL=?, UNIDADE_PESO=? WHERE (ID=?)";
        deleteSql = "DELETE FROM PRODUTO WHERE (ID=?)";
        deleteAllSql = "DELETE FROM PRODUTO";
        countAllSql = "SELECT COUNT(1) FROM PRODUTO";

    }

    public List<Produto> findByNome(String nome) throws SQLException, Exception {
        return executeQuery(findByNameSql, nome);
    }

    @Override
    protected Produto fillObject(ResultSet rs) throws SQLException {
        Produto o = new Produto();
        o.setId(rs.getInt("ID"));
        o.setNome(rs.getString("NOME"));
        o.setPeso(rs.getDouble("PESO"));
        o.setQtdeDisponivel(rs.getDouble("QTDE_DISPONIVEL"));
        o.setUnidadePeso(UnidadePeso.valueOf(rs.getString("UNIDADE_PESO")));
        return o;
    }

    @Override
    protected int bindingObject(PreparedStatement stmt, Produto o) throws SQLException {
        int parameterIndex = 1;
        Produto p = (Produto) o;
        stmt.setString(parameterIndex++, p.getNome());
        stmt.setDouble(parameterIndex++, p.getPeso());
        stmt.setDouble(parameterIndex++, p.getQtdeDisponivel());
        stmt.setString(parameterIndex++, p.getUnidadePeso().toString());
        return parameterIndex;
    }

}

package br.org.catolicasc.cadastro.data;

import br.org.catolicasc.cadastro.model.Categoria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author flavio.kannenberg
 */
public final class CategoriaJdbc extends AbstractJdbcDao<Categoria> {

    public CategoriaJdbc(ConnectionManager mngr) {
        super(mngr);

        findAllSql = "SELECT id, nome, descricao FROM categoria";
        findByIdSql = "SELECT id, nome, descricao FROM categoria WHERE id = ?";
        createSql = "INSERT INTO categoria (nome, descricao) VALUES (?, ?)";
        updateSql = "UPDATE categoria SET nome=?, descricao=? WHERE (id=?)";
        deleteSql = "DELETE FROM categoria WHERE (id=?)";
        deleteAllSql = "DELETE FROM categoria";
        countAllSql = "SELECT COUNT(1) FROM categoria";

    }

    @Override
    protected Categoria fillObject(ResultSet rs) throws SQLException {

        Categoria o = new Categoria();

        o.setId(rs.getInt("id"));
        o.setNome(rs.getString("nome"));
        o.setDescricao(rs.getString("descricao"));

        return o;
    }

    @Override
    protected int bindingObject(PreparedStatement stmt, Categoria o) throws SQLException {
        stmt.setString(1, o.getNome());
        stmt.setString(2, o.getDescricao());
        return 3;
    }

}

package br.org.catolicasc.cadastro.data;

import br.org.catolicasc.cadastro.model.Categoria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author fkannenberg
 */
public class CategoriaJdbc extends AbstractJdbcDao<Categoria> {

    public CategoriaJdbc(ConnectionManager mngr) {
        super(mngr);

        SQL_TO_FIND_ALL = "SELECT id, nome, descricao FROM categoria";
        SQL_TO_FIND_BY_ID = "SELECT id, nome, descricao FROM categoria WHERE id = ?";
        SQL_TO_CREATE = "INSERT INTO categoria (nome, descricao) VALUES (?, ?)";
        SQL_TO_UPDATE = "UPDATE categoria SET nome=?, descricao=? WHERE (id=?)";
        SQL_TO_DELETE = "DELETE FROM categoria WHERE (id=?)";
        SQL_TO_DELETE_ALL = "DELETE FROM categoria";
        SQL_TO_COUNT_ALL = "SELECT COUNT(1) FROM categoria";

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

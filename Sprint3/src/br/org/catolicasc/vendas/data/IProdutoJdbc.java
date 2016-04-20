
package br.org.catolicasc.vendas.data;

import br.org.catolicasc.vendas.model.IProduto;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Cyber
 */
public interface IProdutoJdbc extends IDao<IProduto> {

    List<IProduto> findByNome(String nome) throws SQLException, Exception;
    
}

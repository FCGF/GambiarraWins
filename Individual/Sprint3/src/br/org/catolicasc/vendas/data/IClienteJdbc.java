package br.org.catolicasc.vendas.data;

import br.org.catolicasc.vendas.model.ICliente;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Cyber
 */
public interface IClienteJdbc extends IDao<ICliente> {

    List<ICliente> findByNome(String nome) throws SQLException, Exception;

}

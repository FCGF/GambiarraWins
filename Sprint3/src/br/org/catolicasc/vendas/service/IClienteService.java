package br.org.catolicasc.vendas.service;

import br.org.catolicasc.vendas.data.IClienteJdbc;
import br.org.catolicasc.vendas.model.ICliente;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author flavio.kannenberg
 */
public interface IClienteService extends IService<ICliente, IClienteJdbc> {
     List<ICliente> findByNome(String nome) throws SQLException, Exception;
}

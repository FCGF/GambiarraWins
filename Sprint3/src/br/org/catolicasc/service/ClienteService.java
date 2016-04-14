package br.org.catolicasc.vendas.service;

import br.org.catolicasc.vendas.data.ClienteJdbc;
import br.org.catolicasc.vendas.data.ConnectionManager;
import br.org.catolicasc.vendas.data.IClienteJdbc;
import br.org.catolicasc.vendas.model.ICliente;

/**
 *
 * @author flavio.kannenberg
 */
public class ClienteService extends AbstractService<ICliente, IClienteJdbc>
        implements IClienteService {

    private static ClienteService instance;

    private ClienteService() {
        super();
    }

    private ClienteService(IClienteJdbc dao) {
        super(dao);
    }

    public static ClienteService getInstance() {
        if (instance == null) {
            instance = new ClienteService(
                    new ClienteJdbc(ConnectionManager.getInstance()));
        }
        return instance;
    }

}

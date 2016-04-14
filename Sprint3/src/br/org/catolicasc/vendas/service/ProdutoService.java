package br.org.catolicasc.vendas.service;

import br.org.catolicasc.vendas.data.ConnectionManager;
import br.org.catolicasc.vendas.data.IProdutoJdbc;
import br.org.catolicasc.vendas.data.ProdutoJdbc;
import br.org.catolicasc.vendas.model.IProduto;
import java.util.List;

/**
 *
 * @author flavio.kannenberg
 */
public class ProdutoService
        extends AbstractService<IProduto, IProdutoJdbc>
        implements IProdutoService {

    private static ProdutoService instance;

    private ProdutoService() {
        super();
    }

    private ProdutoService(IProdutoJdbc dao) {
        super(dao);
    }
    
    @Override
    public List<IProduto> findByNome(String nome) throws Exception {
        return getDao().findByNome(nome);
    }

    public static ProdutoService getInstance() {
        if (instance == null) {
            instance = new ProdutoService(
                    new ProdutoJdbc(ConnectionManager.getInstance()));
        }
        return instance;
    }

    
}

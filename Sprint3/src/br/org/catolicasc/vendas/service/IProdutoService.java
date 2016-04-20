package br.org.catolicasc.vendas.service;

import br.org.catolicasc.vendas.data.IProdutoJdbc;
import br.org.catolicasc.vendas.model.IProduto;
import java.util.List;

/**
 *
 * @author GambiarraWins
 */
public interface IProdutoService extends IService<IProduto, IProdutoJdbc> {

    List<IProduto> findByNome(String nome) throws Exception;

}

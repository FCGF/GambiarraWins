package br.org.catolicasc.cadastro.data;

import br.org.catolicasc.cadastro.data.ConnectionManager;
import br.org.catolicasc.cadastro.data.ProdutoJdbc;
import br.org.catolicasc.cadastro.model.Categoria;
import br.org.catolicasc.cadastro.model.Produto;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author GambiarraWins
 */
public class ProdutoJdbcTest {

    private static ProdutoJdbc produtoJdbc;

    @BeforeClass
    public static void setUpClass() throws Exception {
        produtoJdbc = new ProdutoJdbc(ConnectionManager.getInstance());
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        produtoJdbc = null;
    }

    public ProdutoJdbcTest() {
        super();
    }

    @Test
    public void testFindAll() throws Exception {
        List<Produto> produtos = produtoJdbc.findAll();
        assertNotNull(produtos);
        assertTrue(produtos.size() > 0);
    }

    @Test
    public void testFindById() throws Exception {
        final int PRODUTO_ID = 1;
        Produto actual = produtoJdbc.findById(PRODUTO_ID);
        assertNotNull(actual);
        assertEquals(PRODUTO_ID, actual.getId());
        assertNotNull(actual.getNome());
    }

    @Test
    public void testCreate() throws Exception {
        Produto actual = new Produto(0, new Categoria(1), "Teste", 4589.09, 759.98, 12, true);
        produtoJdbc.create(actual);

        assertTrue(actual.getId() > 0);

        System.out.println(actual);
        /*
        Produto produtoPersistente = produtoJdbc.findById(actual.getId());

        assertEquals(actual.getId(), produtoPersistente.getId());
        assertEquals(actual.getNome(), produtoPersistente.getNome());
        assertEquals(actual.getCategoria(), produtoPersistente.getCategoria());
        assertEquals(actual.getPrecoUnitario(), produtoPersistente.getPrecoUnitario());
        assertEquals(actual.getEstoque(), produtoPersistente.getEstoque());
        assertEquals(actual.getQuantidade(), produtoPersistente.getQuantidade());
        assertEquals(actual.isDescontinuado(), produtoPersistente.isDescontinuado());
         */

    }

    @Test
    public void testUpdate() throws Exception {
        /*
        Produto p = produtoJdbc.findById(1);
        assertNotNull(p);
        assertTrue(p.isDescontinuado());
        p.descontinua();

        produtoJdbc.update(p);

        p = produtoJdbc.findById(1);
        assertNotNull(p);
        assertFalse(p.isDescontinuado());

        p.continua();

        produtoJdbc.update(p);
         */
 /*
        Categoria categoria = new Categoria();
        Produto produto = new Produto(0, categoria, "teste", 0, 0, 0, true);
        produtoJdbc.create(produto);
        assertNotNull(produto);
        assertTrue(produto.getId() != 0);

        Produto produtoPersistente = produtoJdbc.findById(produto.getId());
        
        assertNotNull(produtoPersistente);
        assertEquals(produto.getId(), produtoPersistente.getId());
        assertEquals(produto.getNome(), produtoPersistente.getNome());
        assertEquals(produto.getCategoria(), produtoPersistente.getCategoria());
        assertEquals(produto.getPrecoUnitario(), produtoPersistente.getPrecoUnitario());
        assertEquals(produto.getEstoque(), produtoPersistente.getEstoque());
        assertEquals(produto.getQuantidade(), produtoPersistente.getQuantidade());
        assertEquals(produto.isDescontinuado(), produtoPersistente.isDescontinuado());
        
        produto.setNome("Produto Modificado.");
        produto.descontinua();
        
        produtoJdbc.update((produto));
        
        produtoPersistente = produtoJdbc.findById(produto.getId());
        
        assertNotNull(produtoPersistente);
        assertEquals(produto.getId(), produtoPersistente.getId());
        assertEquals(produto.getNome(), produtoPersistente.getNome());
        assertEquals(produto.getCategoria(), produtoPersistente.getCategoria());
        assertEquals(produto.getPrecoUnitario(), produtoPersistente.getPrecoUnitario());
        assertEquals(produto.getEstoque(), produtoPersistente.getEstoque());
        assertEquals(produto.getQuantidade(), produtoPersistente.getQuantidade());
        assertEquals(produto.isDescontinuado(), produtoPersistente.isDescontinuado());
         */
    }

    @Test
    public void testDelete() throws Exception {

        List<Produto> clientes = produtoJdbc.findAll();

        assertNotNull(clientes);

        Produto p = clientes.get(clientes.size() - 1);

        System.out.println("Excluir: " + p);

        produtoJdbc.delete(p);

        p = produtoJdbc.findById(p.getId());

        assertNull(p);
    }

    @Test
    public void testDeleteAll() throws Exception {
    }

    @Test
    public void testCountAll() throws Exception {
        int actual = produtoJdbc.countAll();
        assertTrue(actual > 0);
    }

}

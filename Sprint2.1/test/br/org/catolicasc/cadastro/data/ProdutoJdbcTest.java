package br.org.catolicasc.cadastro.data;

import br.org.catolicasc.cadastro.model.Categoria;
import br.org.catolicasc.cadastro.model.Produto;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author flavio.kannenberg
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
        assertNotEquals(0, produtos.size());
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

        assertNotEquals(0, actual.getId());

        Produto persisted = produtoJdbc.findById(actual.getId());
        assertNotNull(persisted);
        assertEquals(persisted.getId(), actual.getId());
        assertEquals(persisted.getNome(), actual.getNome());
        assertEquals(persisted.getPrecoUnitario(), actual.getPrecoUnitario(), 0);
        assertEquals(persisted.getQuantidade(), actual.getQuantidade(), 0);
        assertEquals(persisted.getEstoque(), actual.getEstoque());
        assertEquals(persisted.getCategoria().getId(), actual.getCategoria().getId());

        produtoJdbc.delete(persisted);

        assertNull(produtoJdbc.findById(persisted.getId()));
    }

    @Test(expected = NullPointerException.class)
    public void testCreateNotFound() throws Exception {
        produtoJdbc.create(null);
    }

    @Test
    public void testUpdate() throws Exception {
        final String NOME = "Kinder Ovo";
        final int ESTOQUE = 987;
        final double QUANTIDADE = 4586.456;
        final double PRECO = 253.99;

        Produto actual = new Produto(0, new Categoria(1), "Teste", 4589.09, 759.98, 12, true);
        produtoJdbc.create(actual);

        assertNotEquals(0, actual.getId());

        Produto persisted = produtoJdbc.findById(actual.getId());
        assertNotNull(persisted);

        persisted.setNome(NOME);
        persisted.setEstoque(ESTOQUE);
        persisted.setQuantidade(QUANTIDADE);
        persisted.setPrecoUnitario(PRECO);

        produtoJdbc.update(persisted);

        persisted = produtoJdbc.findById(actual.getId());
        assertNotNull(persisted);

        assertEquals(NOME, persisted.getNome());
        assertEquals(ESTOQUE, persisted.getEstoque(), 0);
        assertEquals(QUANTIDADE, persisted.getQuantidade(), 0);
        assertEquals(PRECO, persisted.getPrecoUnitario(), 0);

        produtoJdbc.delete(persisted);

        assertNull(produtoJdbc.findById(persisted.getId()));
    }

    @Test(expected = NullPointerException.class)
    public void testUpdateNotFound() throws Exception {
        produtoJdbc.update(null);
    }

    @Test
    public void testDelete() throws Exception {

        Produto actual = new Produto(0, new Categoria(1), "Teste", 4589.09, 759.98, 12, true);
        produtoJdbc.create(actual);

        assertNotEquals(0, actual.getId());

        Produto persisted = produtoJdbc.findById(actual.getId());
        assertNotNull(persisted);
        assertEquals(persisted.getId(), actual.getId());

        produtoJdbc.delete(persisted);

        assertNull(produtoJdbc.findById(persisted.getId()));
    }

    @Test(expected = NullPointerException.class)
    public void testDeleteNotFound() throws Exception {
        produtoJdbc.delete(null);
    }

    @Test
    @Ignore
    public void testDeleteAll() throws Exception {
        // TODO: Não Testar
    }

    @Test
    public void testCountAll() throws Exception {
        int actual = produtoJdbc.countAll();
        assertNotEquals(0, actual);
    }

}
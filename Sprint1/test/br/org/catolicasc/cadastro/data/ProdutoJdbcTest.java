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
        
        
    }

    @Test
    public void testUpdate() throws Exception {
    }

    @Test
    public void testDelete() throws Exception {
    }

    @Test
    public void testDeleteAll() throws Exception {
    }

    @Test
    public void testCountAll() throws Exception {
    }

}

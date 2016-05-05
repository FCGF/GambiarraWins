package br.org.catolicasc.vendas.data;

import br.org.catolicasc.vendas.model.IEntity;
import br.org.catolicasc.vendas.model.IProduto;
import br.org.catolicasc.vendas.model.Produto;
import br.org.catolicasc.vendas.model.UnidadePeso;
import java.util.List;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

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

    @Test
    public void testFindAll() throws Exception {

        List<IProduto> produtos = produtoJdbc.findAll();

        assertNotNull(produtos);
        assertNotSame(0, produtos.size());
        for (IEntity c : produtos) {
            assertNotNull(c);
            assertNotSame(0, c.getId());
        }

    }

    @Test
    public void testFindById() throws Exception {

        IEntity c = produtoJdbc.findById(1);
        assertNotNull(c);

        c = produtoJdbc.findById(999);
        assertNull(c);
    }

    @Test
    public void testFindByName() throws Exception {
        List<IProduto> produtos = produtoJdbc.findByNome("%a%");
        assertNotNull(produtos);
        assertFalse(produtos.isEmpty());
    }

    @Test
    public void testCreate() throws Exception {

        final String NOME = "Bala de Banana";
        final double PESO = 150.0;
        final double QUANTIDADE = 4.55;
        final UnidadePeso UNIDADE = UnidadePeso.GRAMA;

        Produto p = new Produto();
        p.setNome(NOME);
        p.setPeso(PESO);
        p.setQtdeDisponivel(QUANTIDADE);
        p.setUnidadePeso(UNIDADE);

        produtoJdbc.create(p);

        assertNotSame(0, p.getId());

        IProduto actual = produtoJdbc.findById(p.getId());

        assertEquals(NOME, actual.getNome());
        assertEquals(PESO, actual.getPeso(), 0.0);
        assertEquals(QUANTIDADE, actual.getQtdeDisponivel(), 0.0);
        assertEquals(UNIDADE, actual.getUnidadePeso());

        produtoJdbc.delete(actual);
    }

    @Test
    public void testUpdate() throws Exception {

        final String NOME = "Bala de Banana";
        final double PESO = 150.0;
        final double QUANTIDADE = 4.55;
        final UnidadePeso UNIDADE = UnidadePeso.GRAMA;

        IProduto p = new Produto();
        p.setNome(NOME);
        p.setPeso(PESO);
        p.setQtdeDisponivel(QUANTIDADE);
        p.setUnidadePeso(UNIDADE);

        produtoJdbc.create(p);

        assertNotSame(0, p.getId());

        IProduto actual = produtoJdbc.findById(p.getId());

        assertEquals(NOME, actual.getNome());
        assertEquals(PESO, actual.getPeso(), 0.0);
        assertEquals(QUANTIDADE, actual.getQtdeDisponivel(), 0.0);
        assertEquals(UNIDADE, actual.getUnidadePeso());

        actual.setNome("Bala de banana branca");
        actual.setPeso(1.0);
        actual.setQtdeDisponivel(100.0);
        actual.setUnidadePeso(UnidadePeso.QUILOGRAMA);

        produtoJdbc.update(actual);

        p = produtoJdbc.findById(actual.getId());

        assertEquals(actual.getNome(), p.getNome());
        assertEquals(actual.getPeso(), p.getPeso(), 0.0);
        assertEquals(actual.getQtdeDisponivel(), p.getQtdeDisponivel(), 0.0);
        assertEquals(actual.getUnidadePeso(), p.getUnidadePeso());
    }

    @Test
    public void testDelete() throws Exception {

        final String NOME = "Bala de Banana";
        final double PESO = 150.0;
        final double QUANTIDADE = 4.55;
        final UnidadePeso UNIDADE = UnidadePeso.GRAMA;

        Produto p = new Produto();
        p.setNome(NOME);
        p.setPeso(PESO);
        p.setQtdeDisponivel(QUANTIDADE);
        p.setUnidadePeso(UNIDADE);

        produtoJdbc.create(p);

        assertNotSame(0, p.getId());

        assertNotNull(produtoJdbc.findById(p.getId()));

        produtoJdbc.delete(p);

        assertNull(produtoJdbc.findById(p.getId()));
    }

    @Test
    public void testCountAll() throws Exception {
        assertNotSame(0, produtoJdbc.countAll());
    }

}

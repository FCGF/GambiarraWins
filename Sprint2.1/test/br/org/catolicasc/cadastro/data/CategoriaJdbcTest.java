package br.org.catolicasc.cadastro.data;

import br.org.catolicasc.cadastro.model.Categoria;
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
public class CategoriaJdbcTest {

    public CategoriaJdbcTest() {
    }

    private static CategoriaJdbc categoriaJdbc;

    @BeforeClass
    public static void setUpClass() throws Exception {
        categoriaJdbc = new CategoriaJdbc(ConnectionManager.getInstance());
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        categoriaJdbc = null;
    }

    @Test
    public void testFindAll() throws Exception {
        List<Categoria> categorias = categoriaJdbc.findAll();
        assertNotNull(categorias);
        assertNotEquals(0, categorias.size());
        //
        for (Categoria categoria : categorias) {
            System.out.println("--> " + categoria);
        }
    }

    @Test
    public void testFindById() throws Exception {
        final int CATEGORIA_ID = 2;
        Categoria actual = categoriaJdbc.findById(CATEGORIA_ID);
        assertNotNull(actual);
        assertNotNull(actual.getNome());
        assertNotNull(actual.getDescricao());
    }

    @Test
    public void testFindByIdNotFound() throws Exception {
        final int CATEGORIA_ID = Integer.MAX_VALUE;
        Categoria actual = categoriaJdbc.findById(CATEGORIA_ID);
        assertNull(actual);
    }

    @Test
    public void testCreate() throws Exception {
        Categoria actual = new Categoria(0, "New Categorie", "1234");
        categoriaJdbc.create(actual);

        assertNotEquals(0, actual.getId());
        assertNotNull(actual.getNome());
        assertNotNull(actual.getDescricao());

        Categoria persisted = categoriaJdbc.findById(actual.getId());

        assertEquals(actual.getId(), persisted.getId());
        assertEquals(actual.getNome(), persisted.getNome());
        assertEquals(actual.getDescricao(), persisted.getDescricao());

        categoriaJdbc.delete(actual);

        assertNull(categoriaJdbc.findById(actual.getId()));
    }

    @Test(expected = NullPointerException.class)
    public void testCreateNotFound() throws Exception {
        categoriaJdbc.create(null);
    }

    @Test
    public void testUpdate() throws Exception {
        final String NOME = "nova categoria";
        final String DESCRICAO = "nova descrição";

        Categoria actual = new Categoria(0, NOME, DESCRICAO);
        categoriaJdbc.create(actual);

        assertNotEquals(0, actual.getId());
        assertNotNull(actual.getNome());
        assertNotNull(actual.getDescricao());

        Categoria persisted = categoriaJdbc.findById(actual.getId());
        assertNotNull(persisted);
        assertEquals(NOME, persisted.getNome());
        assertEquals(DESCRICAO, persisted.getDescricao());

        final String NOME_UPDATE = "categoria alterada";
        final String DESCRICAO_UPDATE = "descrição da categoria alterada";

        persisted.setNome(NOME_UPDATE);
        persisted.setDescricao(DESCRICAO_UPDATE);

        categoriaJdbc.update(persisted);

        persisted = categoriaJdbc.findById(actual.getId());
        assertNotNull(persisted);
        assertEquals(NOME_UPDATE, persisted.getNome());
        assertEquals(DESCRICAO_UPDATE, persisted.getDescricao());

        categoriaJdbc.delete(persisted);

        assertNull(categoriaJdbc.findById(actual.getId()));
    }

    @Test(expected = NullPointerException.class)
    public void testUpdateNotFound() throws Exception {
        categoriaJdbc.update(null);
    }

    @Test
    public void testDelete() throws Exception {
        final String NOME = "nova categoria";
        final String DESCRICAO = "nova descrição";

        Categoria actual = new Categoria(0, NOME, DESCRICAO);
        categoriaJdbc.create(actual);

        assertNotEquals(0, actual.getId());

        categoriaJdbc.delete(actual);

        actual = categoriaJdbc.findById(actual.getId());

        assertNull(actual);
    }

    @Test(expected = NullPointerException.class)
    public void testDeleteNotFound() throws Exception {
        categoriaJdbc.delete(null);
    }

    @Test
    @Ignore
    public void testDeleteAll() throws Exception {
        // TODO: Não testar
    }

    @Test
    public void testCountAll() throws Exception {
        int allCount = categoriaJdbc.countAll();
        assertNotEquals(0, allCount);
    }

}

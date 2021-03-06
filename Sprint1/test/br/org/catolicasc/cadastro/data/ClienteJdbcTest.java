package br.org.catolicasc.cadastro.data;

import br.org.catolicasc.cadastro.data.ConnectionManager;
import br.org.catolicasc.cadastro.data.ClienteJdbc;
import br.org.catolicasc.cadastro.model.Cliente;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author GambiarraWins
 */
public class ClienteJdbcTest {

    private static ClienteJdbc clienteJdbc;

    @BeforeClass
    public static void setUpClass() throws Exception {
        clienteJdbc = new ClienteJdbc(ConnectionManager.getInstance());
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        clienteJdbc = null;
    }

    @Test
    public void testFindAll() throws Exception {

        List<Cliente> clientes = clienteJdbc.findAll();

        assertNotNull(clientes);
        assertNotSame(0, clientes.size());
        for (Cliente c : clientes) {
            System.out.println(c);
        }

    }

    @Test
    public void testFindById() throws Exception {

        Cliente c = clienteJdbc.findById(1);
        assertNotNull(c);

        System.out.println(c);

        c = clienteJdbc.findById(999);
        assertNull(c);
    }

    @Test
    public void testCreate() throws Exception {

        Cliente actual = new Cliente(0, "Padaria do Zé", true);

        clienteJdbc.create(actual);

        assertNotSame(0, actual.getId());

        System.out.println(actual);
    }

    @Test
    public void testUpdate() throws Exception {

        Cliente c = clienteJdbc.findById(1);
        assertNotNull(c);
        assertTrue(c.isAtivo());
        c.desativa();

        clienteJdbc.update(c);

        c = clienteJdbc.findById(1);
        assertNotNull(c);
        assertFalse(c.isAtivo());

        c.ativa();

        clienteJdbc.update(c);
    }

    @Test
    public void testDelete() throws Exception {

        List<Cliente> clientes = clienteJdbc.findAll();

        assertNotNull(clientes);

        Cliente c = clientes.get(clientes.size() - 1);

        System.out.println("Excluir: " + c);

        clienteJdbc.delete(c);

        c = clienteJdbc.findById(c.getId());

        assertNull(c);
    }

    @Test
    public void testCountAll() throws Exception {
        int actual = clienteJdbc.countAll();
        assertTrue(actual > 0);
    }

}

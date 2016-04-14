package br.org.catolicasc.vendas.data;

import br.org.catolicasc.vendas.model.Cliente;
import br.org.catolicasc.vendas.model.ICliente;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author fkannenberg
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

        List<ICliente> clientes = clienteJdbc.findAll();

        assertNotNull(clientes);
        assertNotSame(0, clientes.size());
        for (ICliente c : clientes) {
            assertNotNull(c);
            assertNotSame(0, c.getId());
        }

    }

    @Test
    public void testFindById() throws Exception {

        ICliente c = clienteJdbc.findById(1);
        assertNotNull(c);

        c = clienteJdbc.findById(999);
        assertNull(c);
    }
    
     @Test
    public void testFindByName() throws Exception {
        List<ICliente> produtos = clienteJdbc.findByNome("%a%");
        assertNotNull(produtos);
        assertFalse(produtos.isEmpty());
    }

    @Test
    public void testCreate() throws Exception {

        Calendar c = Calendar.getInstance();
        c.set(2000, 5, 10, 0, 0, 0);

        final String NOME = "Padaria do Zé";
        final Date DATA = c.getTime();
        final boolean ATIVO = false;
        final String CONTATO = "Carlos da Silva";
        final double CREDITO = 4593.4236;
        final int CARTAO = 90908;

        Cliente actual = new Cliente(0, NOME, DATA, ATIVO);
        actual.setContato(CONTATO);
        actual.setLimiteCredito(CREDITO);
        actual.setNumeroCartaoCredito(CARTAO);

        clienteJdbc.create(actual);

        assertNotSame(0, actual.getId());

        int currentId = actual.getId();

        ICliente cliente = clienteJdbc.findById(currentId);

        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        assertEquals(NOME, cliente.getNome());
        assertEquals(format.format(DATA), format.format(cliente.getDataNascimento()));
        assertEquals(ATIVO, cliente.isAtivo());
        assertEquals(CONTATO, cliente.getContato());
        assertEquals(CREDITO, cliente.getLimiteCredito(), 0.0);
        assertEquals(CARTAO, cliente.getNumeroCartaoCredito());

        clienteJdbc.delete(actual);
    }

    @Test
    public void testUpdate() throws Exception {

        ICliente c = clienteJdbc.findById(1);
        assertNotNull(c);
        assertTrue(c.isAtivo());
        c.setAtivo(false);

        clienteJdbc.update(c);

        c = clienteJdbc.findById(1);
        assertNotNull(c);
        assertFalse(c.isAtivo());

        c.setAtivo(true);

        clienteJdbc.update(c);
    }

    @Test
    public void testDelete() throws Exception {

        Cliente actual = new Cliente(0, "Padaria do Zé", new Date(), true);
        actual.setContato("XXXX");

        clienteJdbc.create(actual);

        List<ICliente> clientes = clienteJdbc.findAll();

        assertNotNull(clientes);

        ICliente c = clientes.get(clientes.size() - 1);

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

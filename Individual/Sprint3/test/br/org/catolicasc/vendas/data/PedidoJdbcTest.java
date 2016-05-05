package br.org.catolicasc.vendas.data;

import br.org.catolicasc.vendas.model.Cliente;
import br.org.catolicasc.vendas.model.Pedido;
import br.org.catolicasc.vendas.model.StatusPedido;
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
 * @author GambiarraWins
 */
public class PedidoJdbcTest {

    private static PedidoJdbc pedidoJdbc;

    @BeforeClass
    public static void setUpClass() throws Exception {
        pedidoJdbc = new PedidoJdbc(ConnectionManager.getInstance());
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        pedidoJdbc = null;
    }

    @Test
    public void testFindAll() throws Exception {

        List<Pedido> pedidos = pedidoJdbc.findAll();

        assertNotNull(pedidos);
        assertTrue(pedidos.size() > 0);
        for (Pedido c : pedidos) {
            Pedido p = c;
            assertNotNull(p);
            assertTrue(p.getId() > 0);
            assertNotNull(p.getCliente());
            assertTrue(p.getCliente().getId() > 0);
        }
    }

    @Test
    public void testFindById() throws Exception {

        Pedido p = pedidoJdbc.findById(1);
        assertNotNull(p);

        p = pedidoJdbc.findById(999);
        assertNull(p);
    }

    @Test
    public void testCreate() throws Exception {

        Calendar c = Calendar.getInstance();
        c.set(2015, 2, 10, 0, 0, 0);

        final Cliente CLIENTE = new Cliente(4);
        final Date DATA_PEDIDO = c.getTime();
        final String NOME_VENDEDOR = "Carolina Silveira";
        final String OBSERVACAO = "Teste...";
        final StatusPedido STATUS_PEDIDO = StatusPedido.FATURADO;

        Pedido p = new Pedido();
        p.setCliente(CLIENTE);
        p.setData(DATA_PEDIDO);
        p.setVendedor(NOME_VENDEDOR);
        p.setObservacao(OBSERVACAO);
        p.setStatusPedido(STATUS_PEDIDO);

        pedidoJdbc.create(p);

        assertTrue(p.getId() > 0);

        Pedido actual = pedidoJdbc.findById(p.getId());

        assertEquals(CLIENTE.getId(), actual.getCliente().getId());

        final SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        assertEquals(format.format(DATA_PEDIDO), format.format(p.getData()));

        assertEquals(NOME_VENDEDOR, actual.getVendedor());
        assertEquals(OBSERVACAO, actual.getObservacao());
        assertEquals(STATUS_PEDIDO, actual.getStatusPedido());

        pedidoJdbc.delete(actual);
    }

    @Test
    public void testUpdate() throws Exception {

        Calendar c = Calendar.getInstance();
        c.set(2015, 2, 10, 0, 0, 0);

        final Cliente CLIENTE = new Cliente(4);
        final Date DATA_PEDIDO = c.getTime();
        final String NOME_VENDEDOR = "Carolina Silveira";
        final String OBSERVACAO = "Teste...";
        final StatusPedido STATUS_PEDIDO = StatusPedido.FATURADO;

        Pedido p = new Pedido();
        p.setCliente(CLIENTE);
        p.setData(DATA_PEDIDO);
        p.setVendedor(NOME_VENDEDOR);
        p.setObservacao(OBSERVACAO);
        p.setStatusPedido(STATUS_PEDIDO);

        pedidoJdbc.create(p);

        assertTrue(p.getId() > 0);

        Pedido expected = pedidoJdbc.findById(p.getId());

        assertNotNull(expected);

        expected.setCliente(new Cliente(2));

        c.set(2014, 10, 25, 0, 0, 0);
        expected.setData(c.getTime());
        expected.setVendedor("Marcos");
        expected.setObservacao("Outra Observação");
        expected.setStatusPedido(StatusPedido.PREPARANDO_ENTREGA);

        pedidoJdbc.update(expected);

        Pedido actual = pedidoJdbc.findById(p.getId());

        assertEquals(expected.getCliente().getId(), actual.getCliente().getId());

        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        assertEquals(format.format(expected.getData()), format.format(actual.getData()));

        assertEquals(expected.getVendedor(), actual.getVendedor());
        assertEquals(expected.getObservacao(), actual.getObservacao());
        assertEquals(expected.getStatusPedido(), actual.getStatusPedido());

        pedidoJdbc.delete(p);
    }

    @Test
    public void testDelete() throws Exception {

        Calendar c = Calendar.getInstance();
        c.set(2015, 2, 10, 0, 0, 0);

        final Cliente CLIENTE = new Cliente(4);
        final Date DATA_PEDIDO = c.getTime();
        final String NOME_VENDEDOR = "Carolina Silveira";
        final String OBSERVACAO = "Teste...";
        final StatusPedido STATUS_PEDIDO = StatusPedido.FATURADO;

        Pedido p = new Pedido();
        p.setCliente(CLIENTE);
        p.setData(DATA_PEDIDO);
        p.setVendedor(NOME_VENDEDOR);
        p.setObservacao(OBSERVACAO);
        p.setStatusPedido(STATUS_PEDIDO);

        pedidoJdbc.create(p);

        assertTrue(p.getId() > 0);

        pedidoJdbc.delete(p);

        assertNull(pedidoJdbc.findById(p.getId()));
    }

    @Test
    public void testCountAll() throws Exception {
        assertTrue(pedidoJdbc.countAll() > 0);
    }

}

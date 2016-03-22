package br.org.catolicasc.cadastro.data;

import br.org.catolicasc.cadastro.model.Cliente;
import br.org.catolicasc.cadastro.model.Pedido;
import br.org.catolicasc.cadastro.model.StatusPedido;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author GambiarraWins
 */
public class PedidoJdbcTest {

    public PedidoJdbcTest() {
    }

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
    }

    @Test
    public void testFindById() throws Exception {
        final int PRODUTO_ID = 1;
        Pedido actual = pedidoJdbc.findById(PRODUTO_ID);
        assertNotNull(actual);
        assertEquals(PRODUTO_ID, actual.getId());
    }

    @Test
    public void testCreate() throws Exception {
        Date data = Date.from(Instant.now());
        Pedido actual = new Pedido(data, 0);
        actual.setStatusPedido(StatusPedido.FATURADO);
        actual.setVendedor("Vendedor");
        Cliente cliente = new Cliente(1);
        actual.setCliente(cliente);
        pedidoJdbc.create(actual);
        assertTrue(actual.getId() > 0);

        System.out.println(actual);

        Pedido pedidoPersistente = pedidoJdbc.findById(actual.getId());

        assertEquals(actual.getId(), pedidoPersistente.getId());
        assertEquals(actual.getData(), pedidoPersistente.getData());
    }

    @Test
    public void testUpdate() throws Exception {
//        Pedido p = pedidoJdbc.findById(1);
//        assertNotNull(p);
//        String vendedorOriginal = p.getVendedor();
//        String vendedor = "Teste123";
//        p.setVendedor(vendedor);
//        pedidoJdbc.update(p);
//
//        p = pedidoJdbc.findById(1);
//        assertNotNull(p);
//
//        assertEquals(vendedor, p.getVendedor());
//
//        p.setVendedor(vendedorOriginal);
//
//        pedidoJdbc.update(p);

        Date data = Date.from(Instant.now());
        Pedido pedido = new Pedido(data, 0);
        pedido.setStatusPedido(StatusPedido.FATURADO);
        pedido.setVendedor("Vendedor");
        Cliente cliente = new Cliente(1);
        pedido.setCliente(cliente);
        pedidoJdbc.create(pedido);
        assertNotNull(pedido);
        assertTrue(pedido.getId() > 0);

        Pedido pedidoPersistente = pedidoJdbc.findById(pedido.getId());

        assertNotNull(pedidoPersistente);
        assertEquals(pedido.getId(), pedidoPersistente.getId());
        assertEquals(new java.sql.Date(pedido.getData().getTime()), pedidoPersistente.getData());

        pedido.setObservacao("Teste Observação.");
        pedido.setVendedor("Teste vendedor.");

        pedidoJdbc.update(pedido);

        pedidoPersistente = pedidoJdbc.findById(pedido.getId());

        assertNotNull(pedidoPersistente);
        assertEquals(pedido.getId(), pedidoPersistente.getId());
        assertEquals(pedido.getObservacao(), pedidoPersistente.getObservacao());
        assertEquals(pedido.getVendedor(), pedidoPersistente.getVendedor());

        pedidoJdbc.delete(pedidoPersistente);
    }

    @Test
    public void testDelete() throws Exception {
        Date data = Date.from(Instant.now());
        Pedido pedido = new Pedido(data, 0);
        pedido.setStatusPedido(StatusPedido.FATURADO);
        pedido.setVendedor("Vendedor");
        Cliente cliente = new Cliente(1);
        pedido.setCliente(cliente);
        pedidoJdbc.create(pedido);
        assertNotNull(pedido);
        assertTrue(pedido.getId() > 0);

        List<Pedido> pedidos = pedidoJdbc.findAll();

        assertNotNull(pedidos);

        Pedido p = pedidos.get(pedidos.size() - 1);

        System.out.println("Excluir: " + p);

        pedidoJdbc.delete(p);

        p = pedidoJdbc.findById(p.getId());

        assertNull(p);
    }

    @Test
    public void testDeleteAll() throws Exception {
        //Não testado
    }

    @Test
    public void testCountAll() throws Exception {
        Date data = Date.from(Instant.now());
        Pedido pedido = new Pedido(data, 0);
        pedido.setStatusPedido(StatusPedido.FATURADO);
        pedido.setVendedor("Vendedor");
        Cliente cliente = new Cliente(1);
        pedido.setCliente(cliente);
        pedidoJdbc.create(pedido);
        assertNotNull(pedido);
        assertTrue(pedido.getId() > 0);

        int actual = pedidoJdbc.countAll();
        assertTrue(actual > 0);

        pedidoJdbc.delete(pedido);
    }

}

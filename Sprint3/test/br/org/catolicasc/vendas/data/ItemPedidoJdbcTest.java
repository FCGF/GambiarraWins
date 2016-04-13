package br.org.catolicasc.vendas.data;

import br.org.catolicasc.vendas.model.Cliente;
import br.org.catolicasc.vendas.model.ItemPedido;
import br.org.catolicasc.vendas.model.Pedido;
import br.org.catolicasc.vendas.model.Produto;
import br.org.catolicasc.vendas.model.StatusPedido;
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
public class ItemPedidoJdbcTest {

    private static PedidoJdbc pedidoJdbc;
    private static ItemPedidoJdbc itemPedidoJdbc;

    @BeforeClass
    public static void setUpClass() throws Exception {
        pedidoJdbc = new PedidoJdbc(ConnectionManager.getInstance());
        itemPedidoJdbc = new ItemPedidoJdbc(ConnectionManager.getInstance());
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        pedidoJdbc = null;
        itemPedidoJdbc = null;
    }

    @Test
    public void testFindAll() throws Exception {

        List<ItemPedido> itens = itemPedidoJdbc.findAll();

        assertNotNull(itens);
        assertTrue(itens.size() > 0);
        for (ItemPedido i : itens) {
            assertNotNull(i);
            assertTrue(i.getId() > 0);
            assertNotNull(i.getPedido());
            assertTrue(i.getPedido().getId() > 0);
            assertNotNull(i.getProduto());
            assertTrue(i.getProduto().getId() > 0);
            assertTrue(i.getQuantidade() > 0);
            assertTrue(i.getPreco() > 0);
        }
    }

    @Test
    public void testFindById() throws Exception {

        ItemPedido p = itemPedidoJdbc.findById(1);
        assertNotNull(p);

        p = itemPedidoJdbc.findById(999);
        assertNull(p);
    }

    @Test
    public void testFindByPedido() throws Exception {
        Pedido pedido = createCenario();

        List<ItemPedido> itens = itemPedidoJdbc.findByPedido(pedido.getId());

        assertNotNull(itens);
        assertEquals(3, itens.size());

        deleteCenario(pedido);

        assertNull(pedidoJdbc.findById(pedido.getId()));
    }

    @Test
    public void testFindByPedidoAndProduto() throws Exception {
        Pedido pedido = createCenario();

        List<ItemPedido> itens = itemPedidoJdbc.findByPedidoAndProduto(pedido.getId(), 3);

        assertNotNull(itens);
        assertEquals(1, itens.size());

        deleteCenario(pedido);

        assertNull(pedidoJdbc.findById(pedido.getId()));
    }

    private Pedido createCenario() throws Exception {
        final Calendar c = Calendar.getInstance();
        c.set(2015, 2, 10, 0, 0, 0);

        final Cliente CLIENTE = new Cliente(4);
        final Date DATA_PEDIDO = c.getTime();
        final String NOME_VENDEDOR = "Carolina Silveira";
        final String OBSERVACAO = "Teste...";
        final StatusPedido STATUS_PEDIDO = StatusPedido.FATURADO;

        Pedido pedido = new Pedido();
        pedido.setCliente(CLIENTE);
        pedido.setData(DATA_PEDIDO);
        pedido.setVendedor(NOME_VENDEDOR);
        pedido.setObservacao(OBSERVACAO);
        pedido.setStatusPedido(STATUS_PEDIDO);

        pedidoJdbc.create(pedido);

        assertTrue(pedido.getId() > 0);

        ItemPedido item1 = new ItemPedido(0, 10, 4.55, new Produto(1), pedido);
        ItemPedido item2 = new ItemPedido(0, 1, 2.25, new Produto(2), pedido);
        ItemPedido item3 = new ItemPedido(0, 7, 10.89, new Produto(3), pedido);

        itemPedidoJdbc.create(item1);
        itemPedidoJdbc.create(item2);
        itemPedidoJdbc.create(item3);

        assertTrue(item1.getId() > 0);
        assertTrue(item2.getId() > 0);
        assertTrue(item3.getId() > 0);

        pedido.getItens().add(item1);
        pedido.getItens().add(item2);
        pedido.getItens().add(item3);

        return pedido;
    }

    private void deleteCenario(Pedido pedido) throws Exception {
        for (ItemPedido item : pedido.getItens()) {
            itemPedidoJdbc.delete(item);

            assertNull(itemPedidoJdbc.findById(item.getId()));
        }

        pedidoJdbc.delete(pedido);
    }

    @Test
    public void testCreate() throws Exception {
        Pedido pedido = createCenario();

        deleteCenario(pedido);

        assertNull(pedidoJdbc.findById(pedido.getId()));
    }

    @Test
    public void testUpdate() throws Exception {
        Pedido pedido = createCenario();

        final double PRECO = 99.99;
        final int QUANTIDADE = 99;

        for (ItemPedido item : pedido.getItens()) {
            item.setQuantidade(QUANTIDADE);
            item.setPreco(PRECO);
            itemPedidoJdbc.update(item);

            ItemPedido current = itemPedidoJdbc.findById(item.getId());

            assertEquals(QUANTIDADE, current.getQuantidade());
            assertEquals(PRECO, current.getPreco(), 0);
        }

        deleteCenario(pedido);

        assertNull(pedidoJdbc.findById(pedido.getId()));

    }

    @Test
    public void testDelete() throws Exception {
        Pedido pedido = createCenario();

        deleteCenario(pedido);

        assertNull(pedidoJdbc.findById(pedido.getId()));
    }

    @Test
    public void testCountAll() throws Exception {
        assertTrue(itemPedidoJdbc.countAll() > 0);
    }

}

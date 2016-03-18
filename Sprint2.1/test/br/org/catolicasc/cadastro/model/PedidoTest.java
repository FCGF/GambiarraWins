package br.org.catolicasc.cadastro.model;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author GambiarraWins
 */
public class PedidoTest {

    public PedidoTest() {
    }

    private Pedido instance;

    @Before
    public void setUp() {
        final Calendar cal = Calendar.getInstance();
        Date data = cal.getTime();
        instance = new Pedido(data, 10);
    }

    @After
    public void tearDown() {
        instance = null;
    }

    @Test
    public void testSetVendedor() {
        System.out.println("setVendedor");
        String vendedor = "";
        Pedido instance = new Pedido();
        instance.setVendedor(vendedor);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetObservacao() {
        System.out.println("setObservacao");
        String observacao = "";
        Pedido instance = new Pedido();
        instance.setObservacao(observacao);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetCliente() {
        System.out.println("setCliente");
        Cliente cliente = null;
        Pedido instance = new Pedido();
        instance.setCliente(cliente);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetData() {
        System.out.println("setData");
        Date data = null;
        Pedido instance = new Pedido();
        instance.setData(data);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetItens() {
        System.out.println("setItens");
        List<ItemPedido> itens = null;
        Pedido instance = new Pedido();
        instance.setItens(itens);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetStatusPedido() {
        System.out.println("setStatusPedido");
        StatusPedido statusPedido = null;
        Pedido instance = new Pedido();
        instance.setStatusPedido(statusPedido);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCalcularPreco() {
        System.out.println("calcularPreco");
        Pedido instance = new Pedido();
        double expResult = 0.0;
        double result = instance.calcularPreco();
        assertEquals(expResult, result, 0.0);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCalcularPeso() {
        System.out.println("calcularPeso");
        Pedido instance = new Pedido();
        double expResult = 0.0;
        double result = instance.calcularPeso();
        assertEquals(expResult, result, 0.0);
        fail("The test case is a prototype.");
    }

}

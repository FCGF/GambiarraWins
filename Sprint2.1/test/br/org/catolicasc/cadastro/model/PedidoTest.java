package br.org.catolicasc.cadastro.model;

import java.util.Calendar;
import java.util.Date;
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
        final Date data = cal.getTime();
        instance = new Pedido(data, 10);
    }

    @After
    public void tearDown() {
        instance = null;
    }

    @Test
    public void testSetVendedor() {
        System.out.println("setVendedor");
        String vendedor = "vendedor";
        instance.setVendedor(vendedor);
        assertEquals(vendedor, instance.getVendedor());
    }

    @Test
    public void testSetObservacao() {
        System.out.println("setObservacao");
        String observacao = "observacao";
        instance.setObservacao(observacao);
        assertEquals(observacao, instance.getObservacao());
    }

    @Test
    public void testSetCliente() {
        System.out.println("setCliente");
        final Calendar cal = Calendar.getInstance();
        final Date data = cal.getTime();
        final int id = 5;
        final String nome = "teste";
        final boolean ativo = false;
        Cliente cliente = new Cliente(id, nome, data, ativo);
        instance.setCliente(cliente);
        assertEquals(id, instance.getCliente().getId());
        assertEquals(nome, instance.getCliente().getNome());
        assertFalse(instance.getCliente().isAtivo());
    }

    @Test
    public void testSetData() {
        System.out.println("setData");
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -20);
        Date data = cal.getTime();
        instance.setData(data);
        Date resultado = instance.getData();
        assertEquals(resultado, data);
    }

    @Test
    public void testSetItens() {
        System.out.println("setItens");
        final int id = 7;
        final int quantidade = 3;
        final double preco = 3.14;

        Produto produto = new Produto(6, "teste");
        ItemPedido item = new ItemPedido(quantidade, preco, produto, id);
        instance.getItens().add(item);
        assertEquals(id, instance.getItens().get(0).getId());
        assertEquals(quantidade, instance.getItens().get(0).getQuantidade());
        assertEquals(preco, instance.getItens().get(0).getPreco(), 0);
    }

    @Test
    public void testSetStatusPedido() {
        System.out.println("setStatusPedido");
        StatusPedido statusPedido = StatusPedido.ENVIADO;
        instance.setStatusPedido(statusPedido);
        StatusPedido resultado = instance.getStatusPedido();
        assertEquals(statusPedido.ordinal(), resultado.ordinal());
    }

    @Test
    public void testCalcularPreco() {
        System.out.println("calcularPreco");
        instance.getItens().add(new ItemPedido(3, 10, null, 0));
        instance.getItens().add(new ItemPedido(4, 5, null, 1));
        instance.getItens().add(new ItemPedido(5, 6, null, 2));
        instance.getItens().add(new ItemPedido(2, 3.5, null, 3));
        double expResult = 87.0;
        double result = instance.calcularPreco();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testCalcularPeso() {
        System.out.println("calcularPeso");
        Produto produto = new Produto(1, "Teste");
        produto.setPeso(10);
        produto.setUnidade(UnidadePeso.TONELADA);
        instance.getItens().add(new ItemPedido(3, 10, produto, 0));
        instance.getItens().add(new ItemPedido(4, 5, produto, 1));
        instance.getItens().add(new ItemPedido(5, 6, produto, 2));
        instance.getItens().add(new ItemPedido(2, 3.5, produto, 3));
        double expResult = 140000;
        double result = instance.calcularPeso();
        assertEquals(expResult, result, 0.0);
    }

}

package br.org.catolicasc.cadastro.model;

import java.sql.Date;
import java.time.LocalDate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author GambiarraWins
 */
public class ClienteTest {

    private Cliente cliente;

    public ClienteTest() {
    }

    private Date parseDate(int dia, int mes, int ano) {
        return Date.valueOf(LocalDate.of(ano, mes, dia));
    }

    @Before
    public void setUp() {
        cliente = new Cliente(0, "Nome", parseDate(1, 1, 2000), true);
    }

    @After
    public void tearDown() {
        cliente = null;
    }

    @Test
    public void testSetAtivo() {
        cliente.setAtivo(false);
        assertFalse(cliente.isAtivo());
    }

    @Test
    public void testToString() {
        assertTrue(cliente.toString() != null && !cliente.toString().isEmpty());
    }

    @Test
    public void testSetLimiteCredito() {
        System.out.println("setLimiteCredito");
        double limiteCredito = 0.0;
        Cliente instance = new Cliente();
        instance.setLimiteCredito(limiteCredito);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetNumeroCartaoCredito() {
        System.out.println("setNumeroCartaoCredito");
        double numeroCartaoCredito = 0.0;
        Cliente instance = new Cliente();
        instance.setNumeroCartaoCredito(numeroCartaoCredito);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetContato() {
        System.out.println("setContato");
        String contato = "";
        Cliente instance = new Cliente();
        instance.setContato(contato);
        fail("The test case is a prototype.");
    }

    @Test
    public void testVerificaCredito() {
        System.out.println("verificaCredito");
        double valorCompra = 0.0;
        Cliente instance = new Cliente();
        boolean expResult = false;
        boolean result = instance.verificaCredito(valorCompra);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidaCartao() {
        System.out.println("validaCartao");
        Cliente instance = new Cliente();
        boolean expResult = false;
        boolean result = instance.validaCartao();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

}

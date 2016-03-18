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
        final double limiteCredito = 1500;
        cliente.setLimiteCredito(limiteCredito);
        assertEquals(limiteCredito, cliente.getLimiteCredito(), 0);
    }

    @Test
    public void testSetNumeroCartaoCredito() {
        final double nrCartaoCredito = 6666;
        cliente.setNumeroCartaoCredito(nrCartaoCredito);
        assertEquals(nrCartaoCredito, cliente.getNumeroCartaoCredito(), 0);
    }

    @Test
    public void testSetContato() {
        String contato = "Teste, 123";
        cliente.setContato(contato);
        assertEquals(contato, cliente.getContato());
    }

    @Test
    public void testVerificaCreditoFalse() {
        cliente.setLimiteCredito(1000);
        assertFalse(cliente.verificaCredito(1100));
    }

    @Test
    public void testVerificaCreditoTrue() {
        cliente.setLimiteCredito(1500);
        assertTrue(cliente.verificaCredito(900));
    }

    @Test
    public void testValidaCartaoFalse() {
        cliente.setNumeroCartaoCredito(-5);
        assertFalse(cliente.validaCartao());
    }

    @Test
    public void testValidaCartaoTrue() {
        cliente.setNumeroCartaoCredito(5);
        assertTrue(cliente.validaCartao());
    }
}

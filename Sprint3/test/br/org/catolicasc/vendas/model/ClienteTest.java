package br.org.catolicasc.vendas.model;

import java.util.Calendar;
import java.util.Date;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author fkannenberg
 */
public class ClienteTest {

    private Cliente cliente;

    @Before
    public void setUp() {
        cliente = new Cliente();
    }

    @After
    public void tearDown() {
        cliente = null;
    }

    @Test
    public void testConstrutorPadrao() {
        assertNotNull(cliente);
        assertEquals(0, cliente.getId());
        assertNull(cliente.getNome());
        assertNull(cliente.getDataNascimento());
        assertEquals(0.0, cliente.getLimiteCredito(), 0.0);
        assertEquals(0, cliente.getNumeroCartaoCredito());
        assertNull(cliente.getContato());
    }

    @Test
    public void testConstrutorCustomizado() {
        final int ID = 890;
        final String NOME = "Pedro de Alcantara";
        final Date DATA_NASCIMENTO = criaData(2000, 10, 14);
        final boolean ATIVO = true;

        cliente = new Cliente(ID, NOME, DATA_NASCIMENTO, ATIVO);

        assertEquals(ID, cliente.getId());
        assertEquals(NOME, cliente.getNome());
        assertEquals(DATA_NASCIMENTO, cliente.getDataNascimento());
        assertEquals(ATIVO, cliente.isAtivo());
    }

    @Test
    public void testGetSetId() {
        final int ID = 4321;
        cliente.setId(ID);
        assertEquals(ID, cliente.getId());
    }

    @Test
    public void testGetSetNome() {
        final String NOME = "Maria";
        cliente.setNome(NOME);
        assertEquals(NOME, cliente.getNome());
    }

    @Test
    public void testGetSetDataNascimento() {
        final Date DATA_NASCIMENTO = criaData(1986, 5, 25);

        cliente.setDataNascimento(DATA_NASCIMENTO);
        assertEquals(DATA_NASCIMENTO, cliente.getDataNascimento());
    }

    @Test
    public void testGeSetLimiteCredito() {
        final double LIMITE = 876.98;
        cliente.setLimiteCredito(LIMITE);
        assertEquals(LIMITE, cliente.getLimiteCredito(), 0.0);
    }

    @Test
    public void testGetSetNumeroCartaoCredito() {
        final int NUMERO_CARTAO = 403707549;
        cliente.setNumeroCartaoCredito(NUMERO_CARTAO);
        assertEquals(NUMERO_CARTAO, cliente.getNumeroCartaoCredito());
    }

    @Test
    public void testGetSetContato() {
        final String CONTATO = "Pedro Arraujo";
        cliente.setContato(CONTATO);
        assertEquals(CONTATO, cliente.getContato());
    }

    @Test
    public void testIsSetAtivo() {
        assertFalse(cliente.isAtivo());
        cliente.setAtivo(true);
        assertTrue(cliente.isAtivo());
        cliente.setAtivo(false);
        assertFalse(cliente.isAtivo());
    }

    @Test
    public void testVerificaCredito() {
        cliente.setLimiteCredito(0.0);
        assertFalse(cliente.verificaCredito(10.0));
        assertFalse(cliente.verificaCredito(0.0));
        assertFalse(cliente.verificaCredito(-10.0));

        cliente.setLimiteCredito(100.0);

        assertTrue(cliente.verificaCredito(10.0));
        assertFalse(cliente.verificaCredito(0.0));
        assertFalse(cliente.verificaCredito(-10.0));

        assertTrue(cliente.verificaCredito(99.9));
        assertFalse(cliente.verificaCredito(100.0));
    }

    @Test
    public void testValidaCartao() {

        cliente.setNumeroCartaoCredito(0);
        assertFalse(cliente.validaCartao());

        cliente.setNumeroCartaoCredito(-85478);
        assertFalse(cliente.validaCartao());

        cliente.setNumeroCartaoCredito(999999999);
        assertTrue(cliente.validaCartao());
    }

    @Test
    public void testCalculaIdade() {
        cliente.setDataNascimento(criaData(1986, 5, 25));

        assertEquals(29, cliente.calculaIdade());

        cliente.setDataNascimento(Calendar.getInstance().getTime());

        assertEquals(0, cliente.calculaIdade());

        cliente.setDataNascimento(criaData(2016, 5, 25));

        assertEquals(-1, cliente.calculaIdade());
    }

    @Test
    public void testToString() {
        String actual = cliente.toString();
        assertNotNull(actual);
        assertNotSame("", actual);
    }

    private static Date criaData(int ano, int mes, int dia) {
        Calendar cal = Calendar.getInstance();
        cal.clear();

        cal.set(Calendar.YEAR, ano);
        cal.set(Calendar.MONTH, mes);
        cal.set(Calendar.DATE, dia);

        return cal.getTime();
    }
}

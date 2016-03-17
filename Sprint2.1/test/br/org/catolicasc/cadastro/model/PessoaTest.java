package br.org.catolicasc.cadastro.model;

import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author GambiarraWins
 */
public class PessoaTest {
    
    public PessoaTest() {
    }
    
    private Pessoa instance;
    
    @Before
    public void setUp() {
        instance = new Pessoa() {};
    }
    
    @After
    public void tearDown() {
        instance = null;
    }

    @Test
    public void testSetNome() {
        final String nome = "Teste";
        instance.setNome(nome);
        assertEquals(nome, instance.getNome());
    }

    @Test
    public void testSetDataNascimento() {
        System.out.println("setDataNascimento");
        Date dataNascimento = null;
        Pessoa instance = new PessoaImpl();
        instance.setDataNascimento(dataNascimento);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Pessoa instance = new PessoaImpl();
        String expResult = "";
        String result = instance.getNome();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetDataNascimento() {
        System.out.println("getDataNascimento");
        Pessoa instance = new PessoaImpl();
        Date expResult = null;
        Date result = instance.getDataNascimento();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCalculaIdade() {
        System.out.println("calculaIdade");
        Pessoa instance = new PessoaImpl();
        int expResult = 0;
        int result = instance.calculaIdade();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        Pessoa instance = new PessoaImpl();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    public class PessoaImpl extends Pessoa {
    }
    
}

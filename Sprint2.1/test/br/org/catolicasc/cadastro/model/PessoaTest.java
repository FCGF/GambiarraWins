package br.org.catolicasc.cadastro.model;

import java.time.Instant;
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
public class PessoaTest {

    public PessoaTest() {
    }

    private Pessoa instance;

    @Before
    public void setUp() {
        instance = new Pessoa() {
        };
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
        //UnidadePeso atual = UnidadePeso.GRAMA;
        //produto.setUnidade(atual);
        //UnidadePeso unidade = produto.getUnidade();       
        //assertEquals(unidade, atual);
        
        System.out.println("setDataNascimento");
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR,-20);
        Date dataNascimento = cal.getTime();
        instance.setDataNascimento(dataNascimento);
        Date data = instance.getDataNascimento();
        assertEquals(data, dataNascimento);

    }

    @Test
    public void testCalculaIdade() {
        System.out.println("calculaIdade");
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR,-20);
        Date dataNascimento = cal.getTime();
        instance.setDataNascimento(dataNascimento);
        int result = instance.calculaIdade();
        assertEquals(20, result);
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

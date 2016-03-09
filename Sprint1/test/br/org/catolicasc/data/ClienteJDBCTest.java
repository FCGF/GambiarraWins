/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.data;

import br.org.catolicasc.model.Cliente;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cyber
 */
public class ClienteJDBCTest {

    private static ClienteJDBC clienteJdbc;

    public ClienteJDBCTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        clienteJdbc = new ClienteJDBC();
    }

    @Test
    public void testFindAll() throws Exception {
        List<Cliente> actual = clienteJdbc.findAll();
        assertTrue(actual.size() > 0);
    }

    @Test
    public void testFind() throws ClassNotFoundException, Exception {
        final int CUSTOMER_ID = 1;
        Cliente actual = clienteJdbc.find(CUSTOMER_ID);
        assertNotNull(actual);
        assertEquals(CUSTOMER_ID, actual.getId());

    }

    @Test
    public void testCreate() throws ClassNotFoundException, Exception {
        Cliente cliente = new Cliente(0, "s", true);
        
        cliente = clienteJdbc.create(cliente);
        
        assertNotNull(cliente);
        assertTrue(cliente.getId() != 0);

        Cliente clientePersistente = clienteJdbc.find(cliente.getId());

        assertEquals(cliente.getId(), clientePersistente.getId());
        assertEquals(cliente.getNome(), clientePersistente.getNome());
        assertEquals(cliente.isAtivo(), clientePersistente.isAtivo());

    }

    @Test
    public void testUpdate() throws ClassNotFoundException, Exception {
        Cliente cliente = new Cliente(0, "Teste Cliente", true);
        clienteJdbc.create(cliente);
        assertNotNull(cliente);
        assertTrue(cliente.getId() != 0);

        Cliente clientePersistente = clienteJdbc.find(cliente.getId());
        
        assertNotNull(clientePersistente);
        assertEquals(cliente.getId(), clientePersistente.getId());
        assertEquals(cliente.getNome(), clientePersistente.getNome());
        assertEquals(cliente.isAtivo(), clientePersistente.isAtivo());
        
        cliente.setNome("Cliente Modificado.");
        cliente.setAtivo(false);
        
        clienteJdbc.update((cliente));
        
        clientePersistente = clienteJdbc.find(cliente.getId());
        
        assertNotNull(clientePersistente);
        assertEquals(cliente.getId(), clientePersistente.getId());
        assertEquals(cliente.getNome(), clientePersistente.getNome());
        assertEquals(cliente.isAtivo(), clientePersistente.isAtivo());
    }

    @Test
    public void testDelete() throws ClassNotFoundException, Exception {
        Cliente cliente = new Cliente(0, "Teste Cliente", true);
        
        clienteJdbc.create(cliente);
        
        assertNotNull(cliente);
        assertTrue(cliente.getId() != 0);
        
        clienteJdbc.delete(cliente.getId());
        
        Cliente clientePersistente = clienteJdbc.find(cliente.getId());
          
        assertNull(clientePersistente);
    }

    @Test
    public void testDeleteAll() {
    }

    @Test
    public void testCount() {
    }

}

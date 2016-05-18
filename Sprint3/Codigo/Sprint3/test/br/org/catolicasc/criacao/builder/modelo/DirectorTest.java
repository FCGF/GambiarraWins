/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.criacao.builder.modelo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrador
 */
public class DirectorTest {

    @Test
    public void testConstruct() {
        System.out.println("Construct");
        ConcreteBuilder object = new ConcreteBuilder();
        Director instance = new Director(object);
        instance.Construct();
        String resultado = object.GetResult().getPart();
        assertNotNull(resultado);
        assertEquals("part", resultado);

    }

}

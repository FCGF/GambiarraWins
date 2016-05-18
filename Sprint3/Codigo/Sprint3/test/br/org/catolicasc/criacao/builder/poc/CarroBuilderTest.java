/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.criacao.builder.poc;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cyber
 */
public class CarroBuilderTest {
    
    
    @Test
    public void testBuildPreco() {
        System.out.println("buildPreco");
        CarroBuilder instance = new CarroBuilderImpl();
        instance.buildPreco();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buildDscMotor method, of class CarroBuilder.
     */
    @Test
    public void testBuildDscMotor() {
        System.out.println("buildDscMotor");
        CarroBuilder instance = new CarroBuilderImpl();
        instance.buildDscMotor();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buildAnoDeFabricacao method, of class CarroBuilder.
     */
    @Test
    public void testBuildAnoDeFabricacao() {
        System.out.println("buildAnoDeFabricacao");
        CarroBuilder instance = new CarroBuilderImpl();
        instance.buildAnoDeFabricacao();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buildModelo method, of class CarroBuilder.
     */
    @Test
    public void testBuildModelo() {
        System.out.println("buildModelo");
        CarroBuilder instance = new CarroBuilderImpl();
        instance.buildModelo();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buildMontadora method, of class CarroBuilder.
     */
    @Test
    public void testBuildMontadora() {
        System.out.println("buildMontadora");
        CarroBuilder instance = new CarroBuilderImpl();
        instance.buildMontadora();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCarro method, of class CarroBuilder.
     */
    @Test
    public void testGetCarro() {
        System.out.println("getCarro");
        CarroBuilder instance = new CarroBuilderImpl();
        CarroProduct expResult = null;
        CarroProduct result = instance.getCarro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class CarroBuilderImpl extends CarroBuilder {

        public void buildPreco() {
        }

        public void buildDscMotor() {
        }

        public void buildAnoDeFabricacao() {
        }

        public void buildModelo() {
        }

        public void buildMontadora() {
        }
    }
    
}

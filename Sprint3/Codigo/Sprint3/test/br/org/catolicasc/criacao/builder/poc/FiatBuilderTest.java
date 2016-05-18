/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.criacao.builder.poc;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cyber
 */
public class FiatBuilderTest {
    
   
    @Test
    public void testBuildDscMotor() {
        System.out.println("buildDscMotor");
        FiatBuilder instance = new FiatBuilder();
        instance.buildDscMotor();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buildAnoDeFabricacao method, of class FiatBuilder.
     */
    @Test
    public void testBuildAnoDeFabricacao() {
        System.out.println("buildAnoDeFabricacao");
        FiatBuilder instance = new FiatBuilder();
        instance.buildAnoDeFabricacao();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buildModelo method, of class FiatBuilder.
     */
    @Test
    public void testBuildModelo() {
        System.out.println("buildModelo");
        FiatBuilder instance = new FiatBuilder();
        instance.buildModelo();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buildMontadora method, of class FiatBuilder.
     */
    @Test
    public void testBuildMontadora() {
        System.out.println("buildMontadora");
        FiatBuilder instance = new FiatBuilder();
        instance.buildMontadora();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

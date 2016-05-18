/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.criacao.builder.modelo;

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
public class ConcreteBuilderTest {
    
    
    @Test
    public void testBuildPart() {
        System.out.println("BuildPart");
        ConcreteBuilder instance = new ConcreteBuilder();
        instance.BuildPart();
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

   
    
}

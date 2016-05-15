/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.estrutural.proxy.poc;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author admin
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({br.org.catolicasc.estrutural.proxy.poc.BancoProxyTest.class, br.org.catolicasc.estrutural.proxy.poc.BancoUsuariosTest.class, br.org.catolicasc.estrutural.proxy.poc.TesteBancoProxyTest.class})
public class PocSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}

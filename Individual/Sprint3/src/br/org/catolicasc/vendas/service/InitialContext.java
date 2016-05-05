/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.vendas.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Cyber
 */
public final class InitialContext {
    private static final Logger LOGGER
            =  LogManager.getLogger(InitialContext.class);
    
    public Object lookup(String jndiName){
        Object instance = null;
        
        switch(jndiName){
            case "produtoService":
                instance = ProdutoService.getInstance();
                break;
            case "clienteService":
                instance = ClienteService.getInstance();
            break;
        }
        
        return instance;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.vendas.service;

/**
 *
 * @author Cyber
 */
public final class ServiceLocator {

    private static  Cache cache;
    private static  InitialContext context;
    private ServiceLocator() {
        super();
    }
    
    static {
        cache = new Cache();
        context = new InitialContext();
    }
    
    public static IService getService(String jndiName){
        IService service = cache.resolve(jndiName);
        
        if(service == null){
            service = (IService)context.lookup(jndiName);
            cache.register(jndiName, service);
        }
        
        return service;
    }
    
}

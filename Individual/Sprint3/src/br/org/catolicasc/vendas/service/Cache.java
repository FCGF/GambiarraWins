/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.vendas.service;

import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author GambiarraWins
 */
public final class Cache {
    
    private Map<String, IService> services;
   
    private static final Logger LOGGER =  LogManager.getLogger(Cache.class);

    public Cache() {
        super();
        services = new HashMap<>();
        LOGGER.info("Cache inicializado.");
    }
    
    public IService resolve(String serviceName){
        IService service = null;
        
        if(serviceName == null || serviceName.isEmpty()){
            throw  new IllegalArgumentException("O nome do serviçõ nao foi informado");
        }
        
        if(services.containsKey(serviceName)){
            service = services.get(serviceName);
        }
        
        if(service == null){
            LOGGER.warn("Serviço nao encontrado: " + serviceName);
        }
        return service;
    }
    
    public void register(String serviceName, IService service){
        
        valida(serviceName);
        valida(service);
        
        if(services.containsKey(serviceName)){
             throw new IllegalArgumentException(
                    "Serviço ja registrado. Nome: " + serviceName);
        }
        services.put(serviceName,service);
    }

    private void valida(String serviceName) throws IllegalArgumentException {
        if (serviceName==null || serviceName.isEmpty()){
            throw new IllegalArgumentException(
                    "O nome do servico nao foi informado. ");
        }
    }
    
    private  void valida(IService service) throws IllegalArgumentException{
        if(service == null){
            throw  new NullPointerException("A instancia nao foi informada");
        }
    }
    
    
}

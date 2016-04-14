/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.service;

import br.org.catolicasc.vendas.data.IDao;
import br.org.catolicasc.vendas.model.Cliente;

/**
 *
 * @author Guilherme
 */
public class ClienteService extends AbstractService<Cliente> implements IService<Cliente>{
    
    private static ClienteService instance;
    
    private ClienteService(){
        super();
    }
    
    public ClienteService(IDao<Cliente> dao){
        super(dao);
    }
    
    public static ClienteService getInstant(){
        return new ClienteService();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.vendas.service;

import br.org.catolicasc.vendas.data.IDao;
import br.org.catolicasc.vendas.model.IEntity;
import java.util.List;

/**
 *
 * @author Cyber
 * @param <T>
 */
public abstract class AbstractService<T extends  IEntity> implements IService<IEntity>{

    
    private IDao<T> dao;

    public AbstractService() {
        super();
    }

    public AbstractService(IDao<T> dao) {
        this();
        this.dao = dao;
    }
    
    
    @Override
    public int countAll() throws Exception {
        //Ficam as outras regras de negocio...
        return  dao.countAll();

    }

    @Override
    public void create(IEntity o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(IEntity o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<IEntity> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IEntity findById(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(IEntity o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

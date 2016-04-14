package br.org.catolicasc.vendas.service;

import br.org.catolicasc.vendas.data.IDao;
import br.org.catolicasc.vendas.model.IEntity;
import java.util.List;

/**
 *
 * @author flavio.kannenberg
 * @param <T>
 * @param <K>
 */
public abstract class AbstractService<T extends IEntity, K extends IDao<T>> implements IService<T, K> {

    private K dao;

    public AbstractService() {
        super();
    }

    public AbstractService(K dao) {
        this();
        this.dao = dao;
    }

    protected K getDao() {
        return dao;
    }

    @Override
    public int countAll() throws Exception {
        // ficam as outras regras de negocio...
        return dao.countAll();
    }

    @Override
    public void create(T o) throws Exception {
        dao.create(o);
    }

    @Override
    public void delete(T o) throws Exception {
        dao.delete(o);
    }

    @Override
    public void deleteAll() throws Exception {
        dao.deleteAll();
    }

    @Override
    public List<T> findAll() throws Exception {
        return dao.findAll();
    }

    @Override
    public T findById(int id) throws Exception {
        return dao.findById(id);
    }

    @Override
    public void update(T o) throws Exception {
        dao.update(o);
    }

}

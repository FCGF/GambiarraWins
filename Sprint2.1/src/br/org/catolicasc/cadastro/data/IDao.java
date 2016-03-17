/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.cadastro.data;

import br.org.catolicasc.cadastro.model.IEntity;
import java.util.List;

/**
 *
 * @author GambiarraWins
 */
public interface IDao {

    public int countAll();

    public void create(IEntity o);

    public void delete(IEntity o);

    public void deleteAll(IEntity o);

    public List<IEntity> findAll();

    public IEntity findBy(int id);

    public void update(IEntity o);

}

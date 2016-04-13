package br.org.catolicasc.vendas.model;

import java.io.Serializable;

/**
 *
 * @author fkannenberg
 */
public abstract class Entity implements Serializable, IEntity {

    private int id;

    public Entity() {
        super();
    }

    public Entity(int id) {
        this();
        this.id = id;
    }

    @Override
    public final int getId() {
        return id;
    }

    @Override
    public final void setId(int id) {
        this.id = id;
    }
}

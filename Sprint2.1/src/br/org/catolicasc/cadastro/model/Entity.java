package br.org.catolicasc.cadastro.model;

public abstract class Entity implements IEntity {

    private int id;

    public Entity() {
        super();
    }

    public Entity(int id) {
        this();
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

}

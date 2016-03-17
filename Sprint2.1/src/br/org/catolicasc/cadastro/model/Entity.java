
package br.org.catolicasc.cadastro.model;

/**
 *
 * @author flavio.kannenberg
 */
public abstract class Entity implements IEntity{

    private int id;

    public Entity() {
        super();
    }

    public Entity(int id) {
        this();
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}

package br.org.catolicasc.vendas.util;

/**
 *
 * @author GambiarraWins
 */
public class KeyValue {

    private final int id;
    private final String description;

    public KeyValue(int id, String description) {
        super();
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof KeyValue)) {
            return false;
        }

        KeyValue that = (KeyValue) obj;

        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + getId();
        return hash;
    }

    @Override
    public String toString() {
        return String.format("%d - %s", id, description);
    }

}

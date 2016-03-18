package br.org.catolicasc.cadastro.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author GambiarraWins
 */
public class EntityTest {

    public EntityTest() {
    }

    @Test
    public void testSetId() {
        final int id = 10;
        Entity entidade = new Entity() {};
        entidade.setId(id);
        assertEquals(id, entidade.getId());
    }

    public class EntityImpl extends Entity {
    }

}

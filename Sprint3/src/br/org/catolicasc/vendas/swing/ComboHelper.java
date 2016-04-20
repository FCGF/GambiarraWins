package br.org.catolicasc.vendas.swing;

import br.org.catolicasc.vendas.util.KeyValue;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author GambiarraWins
 */
public final class ComboHelper {

    private ComboHelper() {
        super();
    }

    public static <E extends Enum<E>> DefaultComboBoxModel createModel(E[] values) {

        final Vector<KeyValue> items = new Vector<>();

        for (E value : values) {
            KeyValue key = new KeyValue(value.ordinal(), value.name());
            items.add(key);
        }

        return new DefaultComboBoxModel(items);
    }

}

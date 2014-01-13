
package complementos;

import java.util.Calendar;
import java.util.Random;

/**
 * Numero aleaotrio entre 0 y n.
 * @author Mauri
 *
 */
public class NumAleatorio {

    /**
     * Atributo de la clase Random.
     */
    private Random r;

    /**
     * Numero que indica el final del intervalo.
     */
    private int max;

    /**
     * Numero entre 0 y n.
     * @param n Numero final del intervalo.
     */
    public NumAleatorio(final int n) {
        Calendar calendario = Calendar.getInstance();
        int semilla = calendario.hashCode();
        r = new Random();
        r.setSeed(semilla);
        max = n;
    }

    /**
     * Siguiente numero aleatorio.
     * @return Numero Aleatorio entre 0 y n.
     */
    public final int next() {
        return (r.nextInt(max + 1));
    }
}

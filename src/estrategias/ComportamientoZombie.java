/**
 * Este Paquete contiene las estrategias que adoptaran los personajes.
 */
package estrategias;

/**
 * Esta clase de comportamiento sera uno de los estados de los bots.
 * @author Mauri
 *
 */
public class ComportamientoZombie implements IComportamiento {

    /**
     * Describe los movimientos del personaje segun su estado.
     * @param i posicion actual en el eje vertical.
     * @param j posicion actual en el eje horizontal.
     * @param m posicion a la que se desea mover.
     * @return La misma posicion.
     */
    @Override
    public final int[] moveCommand(int i, int j, final char m) {
        int[] result = new int[2];
        result[0] = i;
        result[1] = j;
        return result;
    }

}

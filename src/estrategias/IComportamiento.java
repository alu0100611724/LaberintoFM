/**
 * Este Paquete contiene las estrategias que adoptaran los personajes.
 */
package estrategias;

/**
 * Interfaz Comportamiento.
 * Describe como actua un personaje.
 * @author Mauri
 *
 */
public interface IComportamiento {

    /**
     * Describe los movimientos del personaje segun su estado.
     * @param i posicion actual en el eje x.
     * @param j posicion actual en el eje y.
     * @param m posicion a la que se desea mover.
     * @return La nueva posicion.
     */
    int[] moveCommand(int i, int j, char m);
}

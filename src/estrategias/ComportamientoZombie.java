/**
 * Este Paquete contiene las estrategias que adoptaran los personajes.
 */
package estrategias;

import complementos.Posicion;

/**
 * Esta clase de comportamiento sera uno de los estados de los bots.
 * @author Mauri
 *
 */
public class ComportamientoZombie implements IComportamiento {

    /**
     * Describe los movimientos del personaje segun su estado.
     * @param pos Posicion en la habitacion.
     * @param m posicion a la que se desea mover.
     * @return La misma posicion.
     */
    @Override
    public final Posicion moveCommand(final Posicion pos, final char m) {
        return pos;
    }

}

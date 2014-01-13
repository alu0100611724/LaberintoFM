/**
 * Este Paquete contiene las estrategias que adoptaran los personajes.
 */
package estrategias;

import complementos.Posicion;

/**
 * Interfaz Comportamiento.
 * Describe como actua un personaje.
 * @author Mauri
 *
 */
public interface IComportamiento {

    /**
     * Describe los movimientos del personaje segun su estado.
     * @param pos Posicion en la habitacion.
     * @param m posicion a la que se desea mover.
     * @return La nueva posicion.
     */
    Posicion moveCommand(Posicion pos, char m);
}

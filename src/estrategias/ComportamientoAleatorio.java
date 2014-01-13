/**
 * Este Paquete contiene las estrategias que adoptaran los personajes.
 */
package estrategias;

import productos.NumAleatorio;
import productos.Posicion;

/**
 * Esta clase de comportamiento sera uno de los estados de los bots.
 * @author Mauri
 *
 */
public class ComportamientoAleatorio implements IComportamiento {

    /**
     * Describe los movimientos del personaje segun su estado.
     * @param pos Posicion en la habitacion.
     * @param m posicion a la que se desea mover.
     * @return La misma posicion.
     */
    @Override
    public final Posicion moveCommand(final Posicion pos, final char m) {
        Posicion pos2 = new Posicion(pos.getRow(), pos.getCol());
        NumAleatorio n = new NumAleatorio(3);
        switch (n.next()) {
        case 0: pos2.setRow(pos2.getRow() - 1); //arriba
                  break;
        case 1: pos2.setRow(pos2.getRow() + 1); //abajo
                  break;
        case 2: pos2.setCol(pos2.getCol() - 1); //izquierda
                  break;
        case 3: pos2.setCol(pos2.getCol() + 1); //derecha
                  break;
        default:  break;
        }
        return pos2;
    }
}

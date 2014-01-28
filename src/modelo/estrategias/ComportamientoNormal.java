/**
 * Este Paquete contiene las estrategias que adoptaran los personajes.
 */
package modelo.estrategias;

import modelo.complementos.Posicion;

/**
 * Esta clase de comportamiento sera la que utilicen los jugadores.
 * @author Mauri
 *
 */
public class ComportamientoNormal implements IComportamiento {

    /**
     * Describe los movimientos del personaje segun su estado.
     * @param pos Posicion en la habitacion.
     * @param m posicion a la que se desea mover.
     * @return La nueva posicion.
     */
    @Override
    public final Posicion moveCommand(final Posicion pos, final char m) {
        Posicion pos2 = new Posicion(pos.getRow(), pos.getCol());
        switch (m) {
        case 'w': pos2.setRow(pos2.getRow() - 1); //arriba
                  break;
        case 's': pos2.setRow(pos2.getRow() + 1); //abajo
                  break;
        case 'a': pos2.setCol(pos2.getCol() - 1); //izquierda
                  break;
        case 'd': pos2.setCol(pos2.getCol() + 1);
                  break;
        default:  break;
        }
        return pos2;
    }

}

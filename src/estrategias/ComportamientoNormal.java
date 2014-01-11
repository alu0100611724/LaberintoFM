/**
 * Este Paquete contiene las estrategias que adoptaran los personajes.
 */
package estrategias;

/**
 * Esta clase de comportamiento sera la que utilicen los jugadores.
 * @author Mauri
 *
 */
public class ComportamientoNormal implements IComportamiento {

    /**
     * Describe los movimientos del personaje segun su estado.
     * @param i posicion actual en el eje vertical.
     * @param j posicion actual en el eje horizontal.
     * @param m posicion a la que se desea mover.
     * @return La nueva posicion.
     * @throws IllegalArgumentException No es una posicion valida.
     */
    @Override
    public final int[] moveCommand(int i, int j, final char m)
            throws IllegalArgumentException {
        switch (m) {
        case 'w': i--; //arriba
                  break;
        case 's': i++; //abajo
                  break;
        case 'a': j--; //izquierda
                  break;
        case 'd': j++; //derecha
                  break;
        default:  throw new IllegalArgumentException("Tecla no admitida.");
        }
        int[] result = new int[2];
        result[0] = i;
        result[1] = j;
        return result;
    }

}

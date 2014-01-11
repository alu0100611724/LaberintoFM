/**
 * Este Paquete contiene las estrategias que adoptaran los personajes.
 */
package estrategias;

import java.util.Calendar;
import java.util.Random;

import productos.NumAleatorio;

/**
 * Esta clase de comportamiento sera uno de los estados de los bots.
 * @author Mauri
 *
 */
public class ComportamientoAleatorio implements IComportamiento {

    /**
     * Describe los movimientos del personaje segun su estado.
     * @param i posicion actual en el eje vertical.
     * @param j posicion actual en el eje horizontal.
     * @param m posicion a la que se desea mover.
     * @return La misma posicion.
     */
    @Override
    public final int[] moveCommand(int i, int j, final char m) {
        NumAleatorio n = new NumAleatorio(3);
        switch (n.next()) {
        case 0: i--; //arriba
                  break;
        case 1: i++; //abajo
                  break;
        case 2: j--; //izquierda
                  break;
        case 3: j++; //derecha
                  break;
        default:  break;
        }
        int[] result = new int[2];
        result[0] = i;
        result[1] = j;
        return result;
    }
}

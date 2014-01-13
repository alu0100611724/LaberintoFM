
package productos;

import estrategias.ComportamientoAleatorio;
import estrategias.ComportamientoNormal;
import estrategias.IComportamiento;

/**
 * Clase Monstruo que es el enemigo del heroe en el juego del laberinto.
 * @author Mauri
 *
 */
public class Monstruo extends Personaje {
    /**
     * Constructor Monstruo con comportamiento predefinido.
     */
    public Monstruo() {
        super();
        setComp(new ComportamientoAleatorio());
        setImagen('M');
    }
    /**
     * Constructor Monstruo con comportamiento asignado.
     * @param comp Comportamiento
     */
    public Monstruo(final IComportamiento comp) {
        super(comp);
        setImagen('M');
    }

    /**
     * Constructor Monstruo con comportamiento asignado.
     * @param comp Comportamiento
     * @param posicion Posicion del Monstruo en la habitacion.
     */
    public Monstruo(final IComportamiento comp, final Posicion posicion) {
        super(comp);
        setImagen('M');
        setPos(posicion);
    }
}


package productos;

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
}

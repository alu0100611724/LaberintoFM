
package productos;

import estrategias.IComportamiento;

/**
 * Clase Heroe o protagonista del juego del laberinto.
 * @author Mauri
 *
 */
public class Heroe extends Personaje {
    /**
     * Constructor Heore con comportamiento predefinido.
     */
    public Heroe() {
        super();
        setImagen('@');
    }
    /**
     * Constructor Heroe con comportamiento asignado.
     * @param comp Comportamiento
     */
    public Heroe(final IComportamiento comp) {
        super(comp);
        setImagen('@');
    }
}

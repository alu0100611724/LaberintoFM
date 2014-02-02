
package modelo.productos;

import modelo.complementos.Posicion;
import modelo.estrategias.ComportamientoNormal;
import modelo.estrategias.IComportamiento;

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
        setComp(new ComportamientoNormal());
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

    /**
     * Constructor Heroe con comportamiento asignado.
     * @param comp Comportamiento
     * @param posicion Posicion del heroe en la habitacion.
     */
    public Heroe(final IComportamiento comp, final Posicion posicion) {
        super(comp);
        setImagen('@');
        setPos(posicion);
    }
}

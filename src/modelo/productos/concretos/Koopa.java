
package modelo.productos.concretos;

import modelo.productos.Monstruo;

/**
 * Clase Koopa (enemigo de Mario).
 * @author Mauri
 *
 */
public class Koopa extends Monstruo {
    /**
     * Constructor.
     */
    public Koopa() {
        setImagen('K');
        setRutaImg("images/koopa.png");
    }
}

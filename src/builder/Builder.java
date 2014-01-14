
package builder;

import productos.Habitacion;
import productos.Heroe;
import productos.Laberinto;
import productos.Monstruo;

/**
 * Interfaz Builder para construir laberintos.
 * @author Mauri
 *
 */
public abstract class Builder {

    /**
     * Fabrica el Laberinto (Producto).
     * @return El Laberinto.
     */
    public abstract Laberinto fabricarLab();

    /**
     * Fabrica la Habitacion.
     * @param size Tamano de la habitacion (cuadrada).
     * @return La Habitacion.
     */
    public abstract Habitacion fabricarHab(final int size);

    /**
     * Fabrica el Heroe.
     * @return El Heroe.
     */
    public abstract Heroe fabricarHeroe();

    /**
     * Fabrica el Monstruo.
     * @return El Nonstruo.
     */
    public abstract Monstruo fabricarMonstruo();

    /**
     * Cronstruye el Laberinto en el que juegar.
     * @return El Laberinto.
     */
    public abstract Laberinto crearLab();
}

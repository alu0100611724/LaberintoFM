
package builder;

import productos.Laberinto;

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
    public abstract Laberinto getLab();

    /**
     * Fabrica la Habitacion con todos sus elementos.
     * @param size Tamano de la habitacion (cuadrada).
     * @param nMonstruos Numero de monstruos.
     * @param nHabs Numero de habitaciones a crear.
     */
    public abstract void fabricarHab(final int size, final int nMonstruos,
                                     final int nHabs);

    /**
     * Conecta 2 habitaciones del laberinto.
     * @param pO Puerta de Origen.
     * @param hO Habitacion de Origen.
     * @param pD Puerta de Destino.
     * @param hD Puerta de Destino.
     */
    public abstract void conectar(final int pO, final int hO,
                                  final int pD, final int hD);

    /**
     * Selecciona la habitacion actaul.
     * @param i Id de la Habitacio.
     */
    public abstract void setHabActual(final int i);

}

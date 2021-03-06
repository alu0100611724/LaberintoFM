
package modelo.builder;

import modelo.productos.Heroe;
import modelo.productos.Laberinto;
import modelo.productos.Personaje;
import modelo.productos.concretos.Koopa;
import modelo.productos.concretos.MarioHab;
import modelo.productos.concretos.MarioLab;

/**
 * Juego Laberinto Mario Bros. Builder.
 * @author Mauri
 *
 */
public class JuegoMarioLabBuilder extends Builder {

    /**
     * Contador de Habitaciones en el laberinto.
     */
    private int cont = 0;

    /**
     * Laberinto (producto).
     */
    private Laberinto lab;

    /**
     * Constructor.
     */
    public JuegoMarioLabBuilder() {
        lab = new MarioLab();
    }

    /**
     * Fabrica el Laberinto (Producto).
     * @return El Laberinto.
     */
    public final Laberinto getLab() {
        return lab;
    }

    /**
     * Fabrica la Habitacion con todos sus elementos.
     * @param size Tamano de la habitacion (cuadrada).
     * @param nMonstruos Numero de monstruos.
     * @param nHabs Numero de habitaciones a crear.
     * @throws IllegalArgumentException Numero de monstruos no valido.
     */
    public final void fabricarHab(final int size, final int nMonstruos,
                       final int nHabs) throws IllegalArgumentException {
        if ((nMonstruos < 0) || (nMonstruos > size - 2)) {
            throw new IllegalArgumentException("El numero de monstruos debe "
                    + "ser un numero positivo y menor que el tam Habitacion.");
        }
        MarioHab hab = new MarioHab(size);
        hab.addPuertas();
        if (cont == (nHabs - 1)) {
            hab.addPersonaje(new Personaje());
        }
        cont++;
        for (int i = 0; i < nMonstruos; i++) {
            hab.addPersonaje(new Koopa());
        }
        hab.addPersonaje(new Heroe());
        lab.addHab(hab);
    }

    /**
     * Conecta 2 habitaciones del laberinto.
     * @param pO Puerta de Origen.
     * @param hO Habitacion de Origen.
     * @param pD Puerta de Destino.
     * @param hD Puerta de Destino.
     */
    public final void conectar(final int pO, final int hO,
                               final int pD, final int hD) {
        lab.conectarHabitaciones(pO, hO, pD, hD);
    }

    /**
     * Selecciona la habitacion actaul.
     * @param i Id de la Habitacio.
     */
    public final void setHabActual(final int i) {
        lab.setHabActual(i);
    }
}

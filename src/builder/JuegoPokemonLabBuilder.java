
package builder;

import prodconcretos.Pokemon;
import prodconcretos.PokemonHab;
import prodconcretos.PokemonLab;
import productos.Heroe;
import productos.Laberinto;

/**
 * Juego Pokemon Builder.
 * @author Mauri
 *
 */
public class JuegoPokemonLabBuilder extends Builder {

    /**
     * Laberinto (producto).
     */
    private Laberinto lab;

    /**
     * Constructor.
     */
    public JuegoPokemonLabBuilder() {
        lab = new PokemonLab();
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
        if (nMonstruos < 0) {
            throw new IllegalArgumentException("El numero de monstruos debe "
                    + "ser un numero positivo.");
        }
        PokemonHab hab = new PokemonHab(size);
        hab.addPuertas();
        for (int i = 0; i < nMonstruos; i++) {
            hab.addPersonaje(new Pokemon());
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

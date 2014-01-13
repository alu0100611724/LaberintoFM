
package fabricas;

import productos.Habitacion;
import productos.Heroe;
import productos.Laberinto;
import productos.Monstruo;

/**
 * Fabrica de juegos de laberintos.
 * @author Mauri
 *
 */
public class JuegoLabFactory {

    /**
     * Fabrica el Laberinto (Producto).
     * @return El Laberinto.
     */
    private Laberinto fabricarLab() {
        return new Laberinto();
    }

    /**
     * Fabrica la Habitacion.
     * @param size Tamano de la habitacion (cuadrada).
     * @return La Habitacion.
     */
    private Habitacion fabricarHab(final int size) {
        return new Habitacion(size);
    }

    /**
     * Fabrica el Heroe.
     * @return El Heroe.
     */
    private Heroe fabricarHeroe() {
        return new Heroe();
    }

    /**
     * Fabrica el Monstruo.
     * @return El Nonstruo.
     */
    private Monstruo fabricarMonstruo() {
        return new Monstruo();
    }

    /**
     * Cronstruye el Laberinto en el que juegar.
     * @return El Laberinto.
     */
    public final Laberinto crearLab() {

        // Fabricamos el laberinto
        Laberinto lab = fabricarLab();

        /* Fabricamos la Habitacion 1.
         * De tamano 5, con 1 monstruo y 1 Heroe
         */
        Habitacion h1 = fabricarHab(5);
        h1.addPuertas(1);
        h1.addPersonaje(fabricarMonstruo());
        // El Heroe siempre se debe agregar al final
        h1.addPersonaje(fabricarHeroe());

        /* Fabricamos la Habitacion 2.
         * De tamano 10, con 3 monstruos y 1 Heroe
         */
        Habitacion h2 = fabricarHab(10);
        h2.addPuertas(2);
        h2.addPersonaje(fabricarMonstruo());
        h2.addPersonaje(fabricarMonstruo());
        h2.addPersonaje(fabricarMonstruo());
        h2.addPersonaje(fabricarHeroe());

        /* Fabricamos la Habitacion 3.
         * De tamano 8, con 2 monstruos y 1 Heroe
         */
        Habitacion h3 = fabricarHab(7);
        h3.addPuertas(1);
        h3.addPersonaje(fabricarMonstruo());
        h3.addPersonaje(fabricarMonstruo());
        h3.addPersonaje(fabricarHeroe());

        // Agregamos las habitaciones al laberinto
        lab.addHab(h1);
        lab.addHab(h2);
        lab.addHab(h3);

        /* Conectamos las habitaciones indicando_
         * Puerta Origen, Hab Origen, Puerta Destino, Hab Destino.
         * Las Habitaciones estan en un array por lo que la hab1 es en
         * realidad la 0.
         */
        lab.conectarHabitaciones(1, 0, 1, 1);
        lab.conectarHabitaciones(1, 2, 2, 1);

        // Establecemos la Habitacion actual (La que se pinta).
        lab.setHabActual(1);

        // Por ultimo retornamos el laberinto listo para jugar.
        return lab;
    }
}

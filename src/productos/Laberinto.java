package productos;

import java.util.ArrayList;

/**
 * Clase que representa al laberinto.
 * @author Mauri
 *
 */
public class Laberinto {

    /* Crear un metodo conectar puerta x de la hab actual
     * con la puerta y de otra habitacion.
     * conectarHabs(int x, int y, int h2) {}
     */
    /**
     * El laberinto esta formado por habitaciones.
     */
    private ArrayList < Habitacion > habitaciones;

    /**
     * Esta es la habitacion que se debe mostrar en el juego.
     * Debe ser la misma en la que se encuentre el heroe.
     */
    private int habActual;

    /**
     * Devuelve la habitacion donde esta el heroe.
     * @return the habActual
     */
    public final int getHabActual() {
        return habActual;
    }

    /**
     * Decimos cual es la habitacion donde esta el heroe.
     * @param hab the habActual to set.
     * @throws IllegalArgumentException Habitacion no existe.
     */
    public final void setHabActual(int hab) throws IllegalArgumentException {
        if ((hab < 0) || (hab >= habitaciones.size())) {
            throw new IllegalArgumentException("La habitacion no existe.");
        }
        this.habActual = hab;
    }

    /**
     * Constructor.
     */
    public Laberinto() {
        habitaciones = new ArrayList < Habitacion >();
        habActual = -1;
    }

    /**
     * Agrega una habitacion al laberinto.
     * @param h habitacion a agregar.
     */
    public final void addHab(final Habitacion h) {
        habitaciones.add(h);
    }

    /**
     * Conecta dos puertas de dos habitaciones.
     * @param p1 Puerta de la primera habitacion.
     * @param hab1 Una de las habitacines a conectar.
     * @param p2 Puerta de la segunda habitacion.
     * @param hab2 Una de las habitacines a conectar.
     * @throws IllegalArgumentException la habitacion no existe.
     */
    public final void conectarHabitaciones(final int p1, final int hab1,
            final int p2, final int hab2) throws IllegalArgumentException {

        if ((hab1 < 0) || (hab1 >= habitaciones.size())
         || (hab2 < 0) || (hab2 >= habitaciones.size())) {
            throw new IllegalArgumentException("La habitacion a la que "
                    + "desea conectar no existe.");
        }
        habitaciones.get(hab1).conectarPuerta(p1, hab2);
        habitaciones.get(hab2).conectarPuerta(p2, hab1);
    }

    /**
     * Pinta la habitacion donde se encuentra el heroe.
     */
    public final void pintar() {
        System.out.println("\nHabitacion " + habActual);
        habitaciones.get(habActual).pintar();
    }
}

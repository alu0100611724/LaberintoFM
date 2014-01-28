package modelo.productos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Clase que representa al laberinto.
 * @author Mauri
 *
 */
public class Laberinto {

    /**
     * El laberinto esta formado por habitaciones.
     */
    protected ArrayList < Habitacion > habitaciones;

    /**
     * Esta es la habitacion que se debe mostrar en el juego.
     * Debe ser la misma en la que se encuentre el heroe.
     */
    protected int habActual;

    /**
     * Constructor.
     */
    public Laberinto() {
        habitaciones = new ArrayList < Habitacion >();
        habActual = -1;
    }

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
        //falta limpiar la pantalla
        System.out.println("\nHabitacion " + (habActual + 1));
        habitaciones.get(habActual).pintar();
    }

    /**
     * Este metodo implementa la jugabilidad en el laberinto.
     */
    public void play() {
        BufferedReader read = new BufferedReader(
                new InputStreamReader(System.in));
        int estado = -1;
        int i = 0;
        do {
            for (int j = 0; j < 25; j++) { //limpiar pantalla
                System.out.println();
            }
            pintar();
            System.out.print("\n\nPresione a,s,d,w para moverse: ");
            try {
                char c = read.readLine().charAt(0);
                estado = habitaciones.get(habActual).play(c);
                //System.out.println("char: " + c + " Estado: " + estado);
            } catch (Exception e) { }
            if (estado != -1) {
                habActual = estado;
            }
            i++; //<------------------------------------------- Esto es temp
            if (i == 20) {
                estado = -2;
            }
        } while (estado != -2);
        System.out.println("\nGAME OVER");
    }
}
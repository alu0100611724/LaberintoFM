/**
 * 
 */
package modelo.productos.concretos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import modelo.productos.Laberinto;

/**
 * Clase Laberinto Pokemon.
 * @author Mauri
 *
 */
public class PokemonLab extends Laberinto {

    /**
     * Tamano de la pantalla.
     */
    private static final int SCREEN = 25;

    /**
     * Constructor.
     */
    public PokemonLab() {
        super();
    }

    /**
     * Este es el metodo que permite jugar en el laberinto.
     */
    public final void play() {
        BufferedReader read = new BufferedReader(
                new InputStreamReader(System.in));
        int estado = -1;
        do {
            // limpiar pantalla
            for (int j = 0; j < SCREEN; j++) {
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
        } while (estado != -2);
     // limpiar pantalla
        for (int j = 0; j < SCREEN; j++) {
            System.out.println();
        }
        System.out.println("\n¡Felicidades! Ya eres todo un maestro Pokemon.");
    }
}

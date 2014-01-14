/**
 * 
 */
package prodconcretos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import productos.Laberinto;

/**
 * CLase Laberinto Bros.
 * @author Mauri
 *
 */
public class MarioLab extends Laberinto {

    /**
     * Tamano de la pantalla.
     */
    private static final int SCREEN = 25;

    /**
     * Constructor.
     */
    public MarioLab() {
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
            System.out.println("\n\nVidas = " + MarioHab.vidas);
            System.out.print("\nPresione a,s,d,w para moverse: ");
            try {
                char c = read.readLine().charAt(0);
                estado = habitaciones.get(habActual).play(c);
                //System.out.println("char: " + c + " Estado: " + estado);
            } catch (Exception e) { }
            if (estado != -1) {
                habActual = estado;
            }
        } while (estado > -2);
     // limpiar pantalla
        for (int j = 0; j < SCREEN; j++) {
            System.out.println();
        }
        if (estado == -2) {
            System.out.println("\nGAME OVER.");
        } else {
            System.out.println("\n¡Felicidades Mario! Has rescatado a Peach.");
        }
    }
}

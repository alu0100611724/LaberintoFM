package cliente;

import fabricas.JuegoLabFactory;
import productos.Laberinto;

/**
 * Representa al ciente que utiliza el framework.
 * @author Mauri
 *
 */
public class Cliente {
    /**
     * Funcion principal que representa al cliente.
     * @param args Argumentos recibidos por consola
     */
    public static void main(final String[] args) {
        try {
            JuegoLabFactory juegoLab = new JuegoLabFactory();
            Laberinto lab = juegoLab.crearLab();
            lab.play();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}



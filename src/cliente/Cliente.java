package cliente;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import fabricas.JuegoLabFactory;
import fabricas.JuegoMarioLabFactory;
import fabricas.JuegoPokemonLabFactory;
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
            JuegoLabFactory juegoLab;

            BufferedReader read = new BufferedReader(
                    new InputStreamReader(System.in));

            System.out.println("\nJuegos de Laberintos:");
            System.out.println("\n1. Mario Bros.");
            System.out.println("2. Pokemon.");
            System.out.print("\nIntroduzca el numero del juego deseado: ");
            char c = read.readLine().charAt(0);
            switch (c) {
            case '1': juegoLab = new JuegoMarioLabFactory();
                break;
            case '2': juegoLab = new JuegoPokemonLabFactory();
                break;
            default: throw new Exception("Numero incorrecto.");
            }

            Laberinto lab = juegoLab.crearLab();
            lab.play();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}



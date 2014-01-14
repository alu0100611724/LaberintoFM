package cliente;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import builder.Builder;
import builder.Director;
import builder.JuegoMarioLabBuilder;
import builder.JuegoPokemonLabBuilder;
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
            Builder builderLab;

            BufferedReader read = new BufferedReader(
                    new InputStreamReader(System.in));

            System.out.println("\nJuegos de Laberintos:");
            System.out.println("\n1. Mario Bros.");
            System.out.println("2. Pokemon.");
            System.out.print("\nIntroduzca el numero del juego deseado: ");
            char c = read.readLine().charAt(0);
            switch (c) {
            case '1': builderLab = new JuegoMarioLabBuilder();
                break;
            case '2': builderLab = new JuegoPokemonLabBuilder();
                break;
            default: throw new Exception("Numero incorrecto.");
            }

            Director dir = new Director(builderLab);
            dir.crearLaberinto();
            Laberinto lab = builderLab.getLab();
            lab.play();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}



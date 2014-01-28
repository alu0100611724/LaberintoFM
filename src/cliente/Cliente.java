package cliente;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import modelo.builder.Builder;
import modelo.builder.Director;
import modelo.builder.JuegoMarioLabBuilder;
import modelo.builder.JuegoPokemonLabBuilder;
import modelo.productos.Laberinto;

/**
 * Representa al ciente que utiliza el framework.
 * @author Mauri
 *
 */
public class Cliente {

    /**
     * Atributo donde se Almacenara el builder.
     */
    private static Builder builderLab;

    /**
     * Metodo para facilitar la creacion del laberinto.
     * @throws Exception Lectura, escritura y otros.
     */
    public static void construirLab() throws Exception {
        BufferedReader read = new BufferedReader(
                new InputStreamReader(System.in));

        System.out.println("\nJuegos de Laberintos:");
        System.out.println("\n1. Mario Bros.");
        System.out.println("2. Pokemon.");
        System.out.println("3. Salir.");
        System.out.print("\nIntroduzca el numero del juego deseado: ");
        char c = read.readLine().charAt(0);
        switch (c) {
        case '1': builderLab = new JuegoMarioLabBuilder();
            break;
        case '2': builderLab = new JuegoPokemonLabBuilder();
            break;
        case '3': System.out.println("Bye.");
            break;
        default: throw new Exception("Numero incorrecto.");
        }
        if (c != '3') {
            Director dir = new Director(builderLab);
            dir.crearLaberinto();
            Laberinto lab = builderLab.getLab();
            lab.play();
        }
    }

    /**
     * Metodo principal del proyecto.
     * @param args Datos recibidos por consola.
     * @throws Exception Captura todas las excepciones.
     */
    public static void main(final String[] args) throws Exception {
        try {
            construirLab();

        } catch (Exception e) {
            for (int i = 0; i < 25; i++) {
                System.out.println();
            }
            System.out.println("Error: " + e.getMessage());
            System.out.println("Intentelo de nuevo.");
            construirLab();
        }
    }
}



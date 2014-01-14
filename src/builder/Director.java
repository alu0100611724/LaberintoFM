
package builder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import prodconcretos.PokemonHab;
import productos.Habitacion;
import productos.Laberinto;

/**
 * Clase Director.
 * Se encarga de recibir las especificaciones y construir el laberinto
 * utilizando la interfaz Builder.
 * @author Mauri
 *
 */
public class Director {

    /**
     * Numero de Habitaciones.
     */
    private int numHab;

    /**
     * Tamano de la Habitacion.
     */
    private int tamHab;

    /**
     * Numero de monstruos.
     */
    private int numMonstruos;

    /**
     * Puerta Origen.
     */
    private int pOrigin;

    /**
     * Puerta Destino.
     */
    private int pDest;

    /**
     * Habitacion Origen.
     */
    private int hOrigin;

    /**
     * Habitacion Destino.
     */
    private int hDest;

    /**
     * Interfaz Builder.
     */
    private Builder builder;

    /**
     * Constructor.
     * @param b Builder.
     */
    public Director(final Builder b) {
        builder = b;
    }

    /**
     * Construye el laberinto con los componentes especificados.
     * @throws Exception Posibles excepciones de entrada de datos.
     */
    public final void crearLaberinto() throws Exception {
        BufferedReader sIn = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.print("\nCuantas Habitaciones desea crear: ");
        numHab = Integer.parseInt(sIn.readLine());

        for (int i = 0; i < numHab; i++) {
            System.out.println("\nConfiguracion Habitacion " + (i + 1) + ": ");
            System.out.print("Tamano: ");
            tamHab = (Integer.parseInt(sIn.readLine()));
            System.out.print("Numero de Monstruos: ");
            numMonstruos = Integer.parseInt(sIn.readLine());
            builder.fabricarHab(tamHab, numMonstruos, numHab);
        }

        do {
        System.out.println("\nConecte las puertas de las habitaciones: ");
        System.out.print("Id Puerta Origen [1-4]: ");
        pOrigin = Integer.parseInt(sIn.readLine());
        System.out.print("Id Habitacion Origen [1-" + numHab + "]: ");
        hOrigin = (Integer.parseInt(sIn.readLine())) - 1;
        System.out.print("Id Puerta Destino [1-4]: ");
        pDest = Integer.parseInt(sIn.readLine());
        System.out.print("Id Habitacion Destino [1-" + numHab + "]: ");
        hDest = (Integer.parseInt(sIn.readLine())) - 1;
        System.out.println("\nDesea continuar conectando habitaciones (s/n): ");
        builder.conectar(pOrigin, hOrigin, pDest, hDest);
        } while (sIn.readLine().equalsIgnoreCase("s"));

        builder.setHabActual(0);
    }
}

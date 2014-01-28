package modelo.complementos;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Clase encargada de controlar los fichero de entrada y salida de objetos.
 * @author Mauri
 *
 */
public class Fichero {

    /**
     * Pide el nombre del fichero por pantalla y formatea la ruta.
     * @return Ruta donde se almacenaran los datos.
     * @throws IOException Entrad/salida por teclado.
     */
    private String getRuta() throws IOException {

        System.out.println("\nIntroduzca el nombre del fichero:");
        //String directorioActual = System.getProperty("user.dir");
        BufferedReader read = new BufferedReader(
                new InputStreamReader(System.in));
        String fichName = read.readLine();
        fichName = System.getProperty("user.dir") + "\\src\\recursos\\"
        + fichName;
        return fichName;

      }

    /**
     * Guarda partidas o laberintos en fichero.
     * @return Flujo de escritura de objetos por fichero.
     * @throws IOException Error de Entrada/Salida por defecto.
     */
    public final ObjectOutputStream escritura() throws IOException {
        String ruta = getRuta();
        FileOutputStream fos = new FileOutputStream(ruta);
        ObjectOutputStream salida = new ObjectOutputStream(fos);
        return salida;
    }

    /**
     * Lee partidas o laberintos guardados en fichero.
     * @return Flujo de lectura de objetos por fichero.
     * @throws IOException Error de Entrada/Salida por defecto.
     */
    public final ObjectInputStream lectura() throws IOException {
        String ruta = getRuta();
        FileInputStream fis = new FileInputStream(ruta);
        ObjectInputStream entrada = new ObjectInputStream(fis);
        return entrada;
    }

}

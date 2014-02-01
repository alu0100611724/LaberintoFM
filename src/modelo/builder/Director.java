
package modelo.builder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import modelo.complementos.Fichero;
import modelo.productos.Laberinto;

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

    /**
     * Crea una Habitacion de tam = size y n mosntruos.
     * @param size Tam habitacion.
     * @param nMonstruos Numero de monstruos.
     */
    public final void crearHab(int size, int nMonstruos) {
        builder.fabricarHab(size, nMonstruos, numHab);
    }

    /**
     * Crea una conexion entre las puertas de dos habitaciones.
     * @param hO Habitacion Origen.
     * @param pO Puerta Origen.
     * @param hD Habitacion Destino.
     * @param pD Puerta Destino.
     */
    public final void crearConexion(int hO, int pO, int hD, int pD)  {
        builder.conectar(pO, hO, pD, hD);
    }

    /**
     * Establece cual es la habitacion que se muestra en el juego.
     * @param hActual Normalmente es la primera habitacion creada.
     */
    public final void habActual(int hActual) {
        builder.setHabActual(hActual);
    }

    /**
     * Guarda el laberinto creado o la partida que se esta jugando.
     * @throws IOException Error de lectura de fichero.
     */
    public final void guardarLab() throws IOException {
        Fichero fichero = new Fichero();
        ObjectOutputStream oos = fichero.escritura();
        oos.writeObject(builder.getLab());
    }

    /**
     * Carga el laberinto creado o la partida que se estaba jugando.
     * @throws IOException Error de lectura de fichero.
     * @throws ClassNotFoundException Error de clase.
     * @return Laberinto.
     */
    public final Laberinto cargarLab() throws IOException,
        ClassNotFoundException {

        Fichero fichero = new Fichero();
        ObjectInputStream ois = fichero.lectura();

        return ((Laberinto) ois.readObject());
    }

    /**
     * Carga el laberinto predeterminado.
     * @throws IOException Error de lectura de fichero.
     * @throws ClassNotFoundException Error de clase.
     * @return Laberinto.
     */
    public final Laberinto cargarPredeterminado() throws IOException,
        ClassNotFoundException {

        Fichero fichero = new Fichero();
        ObjectInputStream ois = fichero.lecturaPredetetminada();

        return ((Laberinto) ois.readObject());
    }

    // -------------------------
    // GETTERS Y SETTERS
    // -------------------------
    /**
     * @return the numHab
     */
    public final int getNumHabs() {
        return numHab;
    }

    /**
     * @param numHabs the numHab to set
     */
    public final void setNumHabs(int numHabs) {
        this.numHab = numHabs;
    }

    /**
     * @return the tamHab
     */
    public final int getTamHab() {
        return tamHab;
    }

    /**
     * @param tamHabitacion the tamHab to set
     */
    public final void setTamHab(int tamHabitacion) {
        this.tamHab = tamHabitacion;
    }

    /**
     * @return the numMonstruos
     */
    public final int getNumMonstruos() {
        return numMonstruos;
    }

    /**
     * @param numMonstruosHab the numMonstruos to set
     */
    public final void setNumMonstruos(int numMonstruosHab) {
        this.numMonstruos = numMonstruosHab;
    }

    /**
     * @return the pOrigin
     */
    public final int getPuertaOrigin() {
        return pOrigin;
    }

    /**
     * @param puertaOrigin the pOrigin to set
     */
    public final void setPuertaOrigin(int puertaOrigin) {
        this.pOrigin = puertaOrigin;
    }

    /**
     * @return the pDest
     */
    public final int getPuertaDest() {
        return pDest;
    }

    /**
     * @param puertaDest the pDest to set
     */
    public final void setPuertaDest(int puertaDest) {
        this.pDest = puertaDest;
    }

    /**
     * @return the hOrigin
     */
    public final int getHabOrigin() {
        return hOrigin;
    }

    /**
     * @param habOrigin the hOrigin to set
     */
    public final void setHabOrigin(int habOrigin) {
        this.hOrigin = habOrigin;
    }

    /**
     * @return the hDest
     */
    public final int getHabDest() {
        return hDest;
    }

    /**
     * @param habDest the hDest to set
     */
    public final void setHabDest(int habDest) {
        this.hDest = habDest;
    }

    /**
     * @return the builder
     */
    public final Builder getBuilder() {
        return builder;
    }

    /**
     * @param builder the builder to set
     */
    public final void setBuilder(Builder builder) {
        this.builder = builder;
    }
}

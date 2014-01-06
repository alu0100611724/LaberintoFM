package productos;

/**
 * Elemento del cual estara formado el laberinto.
 * @author Mauri
 *
 */
public class Habitacion {

    /**
     * Id. autoincremental que se le asignara a cada habitacion.
     */
    private static int cont = 0;

    /**
     * Id. autoincremental que se le asignara a cada habitacion.
     */
    private static final int TAM_MIN = 5;

    /**
     * Id de la habitacion actual.
     */
    private int id;

    /**
     * El tablero almacena los elementos que componen a una habitacion.
     */
    private LugarHab[][] tablero;

    /**
     * Es el tamagno de la habitacion. Las Habitaciones son todas cuadradas.
     */
    private int tam;

    /**
     * Constructor Habitacion.
     * Las habitaciones conforman el laberinto
     * @param t Es el tamagno de la habitacion.
     * @exception IllegalArgumentException Tamangno minimo aceptado de 5.
     */
    public Habitacion(final int t) throws IllegalArgumentException {
        if (t < TAM_MIN) {
            throw new IllegalArgumentException("Tamagno minimo de "
                    + "la habitacion es 5.");
        }
        incrementarCont();
        id = Habitacion.getCont();
        tam = t;
        tablero = new LugarHab[tam][tam];
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                if ((i != 0) && (j != 0) && (i != tam - 1) && (j != tam - 1)) {
                    tablero[i][j] = new LugarHab();
                } else {
                    tablero[i][j] = new Pared();
                }
            }
        }
    }

    /**
     * Devuelve el numero de habitaciones creadas.
     * @return the id
     */
    public static int getCont() {
        return Habitacion.cont;
    }

    /**
     * Incrementa el id. en una unidad.
     */
    private void incrementarCont() {
        Habitacion.cont++;
    }

    /**
     * Devuelve el numero de la habitacion actual.
     * @return nuemero de habitacion.
     */
    public final int getId() {
        return id;
    }

    /**
     * Agrega n puertas a la habitacion.
     * @param n numero de pueras. Maximo 4 puertas por habitacion.
     */
    public void addPuertas(final int n) {

    }

    /**
     * Conecta una puerta de esta habitacion con el id de otra hab.
     * @param i recibe el id de la puerta a la que se desea conectar.
     * @return true si exito, false si error.
     */
    public final boolean conectarPuerta(final int i) {
        return true;
    }

    /**
     * Pinta la habitacion en la pantalla.
     */
    public final void pintar() {
        for (int i = 0; i < tam; i++) {
            System.out.println();
            for (int j = 0; j < tam; j++) {
                System.out.print(" " + tablero[i][j].getImagen());
            }
        }
    }
}

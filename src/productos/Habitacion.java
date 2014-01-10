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
     * Tamano minimo de las habitaciones.
     */
    private static final int TAM_MIN = 5;

    /**
     * Numero de puertas maximo que tiene cada habitacion.
     */
    private static final int MAX_PUERTAS = 4;

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
     * Devuelve el elemento en la posicion (i,j).
     * @param i Eje horizontal.
     * @param j Eje vertical.
     * @return El elemento en dicha posicion.
     */
    public final LugarHab getElemento(final int i, final int j) {
        return tablero[i][j];
    }

    /**
     * Asgian el elemento h en la posicion (i,j).
     * @param h Elemento LugarHab.
     * @param i Eje horizontal.
     * @param j Eje vertical.
     */
    public final void setElemento(final LugarHab h, final int i, final int j) {
        tablero[i][j] = h;
    }

    /**
     * Agrega n puertas a la habitacion.
     * @param n numero de pueras. Maximo 4 puertas por habitacion.
     * @exception IllegalArgumentException Cada habitacion debe
     * tener entre 1 y 4 puertas.
     */
    public void addPuertas(final int n) throws IllegalArgumentException {
        if ((n > MAX_PUERTAS) || (n <= 0)) {
            throw new IllegalArgumentException("Cada habitacion tiene como "
                    + "como min 1 puerta y 4 como maximo.");
        }
        switch (n) {
            case 4:
                tablero[tam - 1][tam / 2] = new Puerta();
            case 3:
                tablero[tam / 2][tam - 1] = new Puerta();
            case 2:
                tablero[tam / 2][0] = new Puerta();
            case 1:
                tablero[0][tam / 2] = new Puerta();
            default:
            break;
        }
    }

    /**
     * Conecta una puerta de esta habitacion con el id de otra hab.
     * @param p Puerta de la habitacion que conecta a otra.
     * @param hab recibe el id de la habitacion a la que se desea conectar.
     * @exception IllegalArgumentException Id incorrecto.
     */
    public final void conectarPuerta(final int p, final int hab)
           throws IllegalArgumentException {

        if ((hab <= 0) || (hab > cont)) {
            throw new IllegalArgumentException("La habitacion a la que "
                    + "desea conectar no existe.");
        }
        switch (p) {
            case 4:
                ((Puerta) tablero[tam - 1][tam / 2]).setOtroLadoPuerta(hab);
                break;
            case 3:
                ((Puerta) tablero[tam / 2][tam - 1]).setOtroLadoPuerta(hab);
                break;
            case 2:
                ((Puerta) tablero[tam / 2][0]).setOtroLadoPuerta(hab);
                break;
            case 1:
                ((Puerta) tablero[0][tam / 2]).setOtroLadoPuerta(hab);
                break;
            default: break;
        }
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

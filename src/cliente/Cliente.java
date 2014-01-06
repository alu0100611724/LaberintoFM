package cliente;

import productos.Habitacion;

/** Mirar Excepciones en constructores pdf pai y JUnit.
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
            Habitacion h = new Habitacion(5);
            h.pintar();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}



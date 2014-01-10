package cliente;

import productos.Habitacion;
import productos.Puerta;

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
            Habitacion h1 = new Habitacion(5);
            h1.addPuertas(4);
            h1.pintar();
            System.out.println("\nCont: " + h1.getCont() + " id:" + h1.getId());
            Habitacion h2 = new Habitacion(5);
            h2.addPuertas(4);
            h2.pintar();
            System.out.println("\nCont: " + h2.getCont() + " id:" + h2.getId());
            h1.conectarPuerta(1, h2.getId());
            h2.conectarPuerta(1, h1.getId());
            System.out.println("debe ser 2: " + ((Puerta) h1.getElemento(0, 2)).getOtroLadoPuerta());
            System.out.println("debe ser 1: " + ((Puerta) h2.getElemento(0, 2)).getOtroLadoPuerta());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}



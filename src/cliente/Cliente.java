package cliente;

import productos.Habitacion;
import productos.Heroe;
import productos.Monstruo;
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
            h1.addPersonaje(new Heroe());
            h1.addPersonaje(new Monstruo());
            h1.addPersonaje(new Monstruo());

            h1.pintar();
            System.out.println("\nCont: " + Habitacion.getCont() + " id:" + h1.getId());
            Habitacion h2 = new Habitacion(8);
            h2.addPuertas(4);
            h2.addPersonaje(new Heroe());
            h2.addPersonaje(new Monstruo());
            h2.pintar();
            System.out.println("\nCont: " + Habitacion.getCont() + " id:" + h2.getId());
            h1.conectarPuerta(1, h2.getId());
            h2.conectarPuerta(1, h1.getId());
            System.out.println("debe ser 2: " + ((Puerta) h1.getElemento(0, 2)).getOtroLadoPuerta());
            System.out.println("debe ser 1: " + ((Puerta) h2.getElemento(0, 4)).getOtroLadoPuerta());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}



package cliente;

import productos.Habitacion;
import productos.Heroe;
import productos.Laberinto;
import productos.Monstruo;
import productos.Puerta;

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
            Laberinto lab = new Laberinto();
            Habitacion h1 = new Habitacion(5);
            h1.addPuertas(4);
            h1.addPersonaje(new Heroe());
            h1.addPersonaje(new Monstruo());
            h1.addPersonaje(new Monstruo());
            lab.addHab(h1);
            Habitacion h2 = new Habitacion(8);
            h2.addPuertas(4);
            h2.addPersonaje(new Heroe());
            h2.addPersonaje(new Monstruo());
            lab.addHab(h2);
            lab.setHabActual(1);
            lab.conectarHabitaciones(1, 0, 1, 1);
            lab.pintar();
            System.out.println("\ndebe ser 1: " + ((Puerta) h1.getElemento(0, 2)).getOtroLadoPuerta());
            System.out.println("debe ser 0: " + ((Puerta) h2.getElemento(0, 4)).getOtroLadoPuerta());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}



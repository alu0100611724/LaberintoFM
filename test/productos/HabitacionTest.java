package productos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Clase para testear el funcionamiento de la clase Habitacion.
 * @author Mauri.
 */
public class HabitacionTest {

    private final static int TAM = 5;

    /**
     * Este atributo sera utilizado para implementar las pruebas.
     */
    private static Habitacion h1;

    /**
     * Este atributo sera utilizado para implementar las pruebas.
     */
    private static Habitacion h2;

    /**
     * Esto se ejecuta antes de lanzar todos los tests.
     * @throws java.lang.Exception excepcion.
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        h1 = new Habitacion(TAM);
        h2 = new Habitacion(TAM);
        h1.addPuertas(4);
        h2.addPuertas(4);
    }

    /**
     * Comprobacion del contador.
     */
    @Test
    public final void testContador() {
        assertEquals(2, Habitacion.getCont());
    }

    /**
     * Test method for getId.
     */
    @Test
    public final void testNumDeHabitacion() {
        assertEquals(1, h1.getId());
        assertEquals(2, h2.getId());
    }

    /**
     * Test method for AddPuertas.
     */
    @Test
    public final void testAddPuertas() {
        assertEquals('#', h1.getElemento(0, 2).getImagen());
        assertEquals('#', h2.getElemento(0, 2).getImagen());
    }

    /**
     * Test method for conectarPuerta.
     */
    @Test
    public final void testConectarPuerta() {
        h1.conectarPuerta(1, h2.getId());
        h2.conectarPuerta(1, h1.getId());

        assertEquals(2, ((Puerta) h1.getElemento(0, 2)).getOtroLadoPuerta());
        assertEquals(1, ((Puerta) h2.getElemento(0, 2)).getOtroLadoPuerta());
    }
}

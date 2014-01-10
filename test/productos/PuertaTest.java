package productos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Clase para testear el funcionamiento de la clase Puerta.
 * @author Mauri.
 *
 */
public class PuertaTest {

    /**
     * Este atributo sera utilizado para implementar las pruebas.
     */
    private Puerta puerta;

    /**
     * Instanciamos el atributo para realizar las pruebas.
     * @throws java.lang.Exception excepcion.
     */
    @Before
    public final void setUp() throws Exception {
        puerta = new Puerta();
    }

    /**
     * Test method for GetOtroLadoPuerta.
     * Comprobamos que el valor que se almacena por defecto es -1.
     */
    @Test
    public final void testGetOtroLadoPuerta() {
        assertEquals(-1, puerta.getOtroLadoPuerta());
    }

    /**
     * Test method for SetOtroLadoPuerta.
     */
    @Test
    public final void testSetOtroLadoPuerta() {
        puerta.setOtroLadoPuerta(1);
        assertEquals(1, puerta.getOtroLadoPuerta());
    }

}

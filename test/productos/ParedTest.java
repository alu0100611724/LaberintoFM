/**
 * Este paquete contiene todos los productos y los elementos que contienes.
 */
package productos;

import static org.junit.Assert.*;
import modelo.productos.Pared;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Clase para testear el funcionamiento de la clase Pared.
 * @author Mauri
 *
 */
public class ParedTest {

    /**
     * Este atributo sera utilizado para implementar las pruebas.
     */
    private Pared pared;

    /**
     * Esto se ejecuta antes de lanzar todos los tests.
     * @throws java.lang.Exception excepcion.
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    /**
     * Esto se ejecuta despues de lanzar todos los tests.
     * @throws java.lang.Exception excepcion.
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    /**
     * Esto se ejecuta antes de un determinado test.
     * Debe de existir tantos como test que los requiran.
     * @throws java.lang.Exception excepcion.
     */
    @Before
    public final void setUp() throws Exception {
        pared = new Pared();
    }

    /**
     * Esto se ejecuta despues de un determinado test.
     * Debe de existir tantos como test que los requiran.
     * @throws java.lang.Exception excepcion.
     */
    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test method for {@link modelo.productos.LugarHab#getImagen()}.
     */
    @Test
    public final void testGetImagen() {
        assertEquals('+', pared.getImagen());
    }

    /**
     * Test method for {@link modelo.productos.LugarHab#setImagen(char)}.
     */
    @Test
    public final void testSetImagen() {
        pared.setImagen('#');
        assertEquals('#', pared.getImagen());
    }

}

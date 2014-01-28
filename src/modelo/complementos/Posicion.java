
package modelo.complementos;

import java.io.Serializable;

/**
 * Indica posicion de un elemento dentro de la habitacion.
 * @author Mauri
 *
 */
public class Posicion implements Serializable {

    /**
     * Id. Serializable.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Fila.
     */
    private int row;

    /**
     * Columna.
     */
    private int col;

    /**
     * Constructor sin parametros.
     * Inicializa row = 0 y col = 0.
     */
    public Posicion() {
        row = 0;
        col = 0;
    }

    /**
     * Constructor con parametros.
     * @param r fila.
     * @param c columna.
     */
    public Posicion(final int r, final int c) {
        row = r;
        col = c;
    }
    /**
     * Devuelve la fila.
     * @return La fila.
     */
    public final int getRow() {
        return row;
    }
    /**
     * Cambia de fila.
     * @param r fila.
     */
    public final void setRow(final int r) {
        this.row = r;
    }
    /**
     * Devuelve la Columna.
     * @return La columna.
     */
    public final int getCol() {
        return col;
    }
    /**
     * Cambia de columna.
     * @param c columna.
     */
    public final void setCol(final int c) {
        col = c;
    }

}

package modelo.productos;

import java.io.Serializable;

/**
 * Esta es la clase padre de todos los elementos pertenecientes a la habitacion.
 * @author Mauri
 *
 */
public class LugarHab implements Serializable {

    /**
     * Id serializable.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Caracter con el que se mostrara el elemento de la habitacion.
     */
    private char imagen;

    private String rutaImg;

    /**
     * @return the imagen
     */
    public final char getImagen() {
        return imagen;
    }

    /**
     * @param img the imagen to set
     */
    public final void setImagen(final char img) {
        this.imagen = img;
    }

    /**
     * @return the rutaImg
     */
    public final String getRutaImg() {
        return rutaImg;
    }

    /**
     * @param rutaImg the rutaImg to set
     */
    public final void setRutaImg(String rutaImg) {
        this.rutaImg = rutaImg;
    }

    /**
     * Constructor que recibe la imagen del elemento.
     * @param i imagen caracter que representa al elemento.
     */
    public LugarHab(final char i) {
        this.imagen = i;
    }

    /**
     * Constructor asigna imagen # por defecto.
     */
    public LugarHab() {
        this.imagen = ' ';
        this.rutaImg = "images/vacio.png";
    }
}

package modelo.productos;

/**
 * La clase Puerta es un elemento de comunicacion entre Habitaciones.
 * @author Mauri
 *
 */
public class Puerta extends LugarHab {

    /**
     * Id. de la habitacion a la que conecta.
     * Si esta a -1 significa que es una puerta falsa que no conecta
     * a ninguna habitacion.
     */
    private int otroLadoPuerta;

    /**
     * Constructor de la clase Puerta.
     * Las puertas conectan dos habitaciones.
     */
    public Puerta() {
        super('#');
        this.otroLadoPuerta = -1;
    }

    /**
     * Regresa el id de la habitacion al otro lado de la puerta.
     * @return id de la habitacion a la que conecta.
     */
    public final int getOtroLadoPuerta() {
        return otroLadoPuerta;
    }

    /**
     * Asigna el id de la habitacion a la que conecta.
     * @param hab id de la habitacion a la que conecta.
     */
    public final void setOtroLadoPuerta(final int hab) {
        this.otroLadoPuerta = hab;
    }

}

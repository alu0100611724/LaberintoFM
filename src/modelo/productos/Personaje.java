package modelo.productos;

import modelo.complementos.Posicion;
import modelo.estrategias.ComportamientoZombie;
import modelo.estrategias.IComportamiento;

/**
 * Elemento que define una pared de la habitacion.
 * @author Mauri
 *
 */
public class Personaje extends LugarHab {

    /**
     * Comportamiento del personaje.
     */
    private IComportamiento c;

    /**
     * Almacena la posicion actual del personaje en la habitacion.
     */
    private Posicion pos;

    /**
     * Constructor Personaje.
     */
    public Personaje() {
        super('&');
        setRutaImg("images/peach.png");
        c = new ComportamientoZombie();
        pos = new Posicion(1, 1);
    }

    /**
     * Constructor Personaje con una estrategia definida.
     * @param comp Comportamiento.
     */
    public Personaje(final IComportamiento comp) {
        super('&');
        setRutaImg("images/peach.png");
        c = comp;
        pos = new Posicion(1, 1);
    }

    /**
     * @return the c
     */
    public final IComportamiento getComp() {
        return c;
    }

    /**
     * @param comp the c to set
     */
    public final void setComp(final IComportamiento comp) {
        this.c = comp;
    }

    /**
     * @return the pos
     */
    public final Posicion getPos() {
        return pos;
    }

    /**
     * @param posicion the pos to set
     */
    public final void setPos(final Posicion posicion) {
        this.pos = posicion;
    }

    /**
     * Describe los movimientos del personaje segun su estado.
     * @param posicion Posicion en la habitacion.
     * @param m posicion a la que se desea mover.
     * @return La nueva posicion.
     */
    public final Posicion move(final Posicion posicion, final char m) {
        return (c.moveCommand(posicion, m));
    }
}

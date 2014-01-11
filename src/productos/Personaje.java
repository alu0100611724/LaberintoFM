package productos;

import estrategias.ComportamientoZombie;
import estrategias.IComportamiento;

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
     * Constructor Personaje.
     */
    public Personaje() {
        super('P');
        c = new ComportamientoZombie();
    }

    /**
     * Constructor Personaje con una estrategia definida.
     * @param comp Comportamiento.
     */
    public Personaje(final IComportamiento comp) {
        super('P');
        c = comp;
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

}

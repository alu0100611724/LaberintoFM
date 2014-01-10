/**
 * Este Paquete contiene las estrategias que adoptaran los personajes.
 */
package Estrategias;

/**
 * Interfaz Comportamiento.
 * Describe como actua un personaje.
 * @author Mauri
 *
 */
public interface IComportamiento {

    /**
     * Describe los movimientos del personaje segun su estado.
     */
    void moveCommand();

    /**
     * Describe la interaccion del personaje segun su estado.
     */
    void combatCommand();
}

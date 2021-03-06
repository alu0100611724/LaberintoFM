
package modelo.productos.concretos;

import modelo.complementos.Posicion;
import modelo.productos.Habitacion;
import modelo.productos.LugarHab;
import modelo.productos.Personaje;
import modelo.productos.Puerta;

/**
 * Habitacion Mario.
 * @author Mauri
 *
 */
public class MarioHab extends Habitacion {

    /**
     * Contador vidas.
     */
    public static int vidas = 3;

    /**
     * Constructor.
     * @param size Tamano de la habitacion.
     */
    public MarioHab(final int size) {
        super(size);
    }

    /**
     * Metodo Play.
     * Establece las reglas del juego.
     * @param dir Direccion a la que se desea mover.
     * @return -1 => misma habitacion, -2 => you win, -3 => You lose y en
     * otro caso el id de la nueva habitacionActual.
     */
    @Override
    public final int play(char dir) {
        //Mover HEROE
        Personaje heroe = personajes.get(personajes.size() - 1);
        Posicion p1 = heroe.getPos();
        Posicion p2 = heroe.move(p1, dir);
        switch (getElemento(p2).getImagen()) {
        case ' ': //si es vacion
            heroe.setPos(p2);
            setElemento(heroe, p2); // movemos al heroe
            setElemento(new LugarHab(), p1); // vaciamos su antigua posicion.
            break;
        case '#': // si es una puerta
            return (((Puerta) getElemento(p2)).getOtroLadoPuerta());
        case '&': //si encuentro a peach gano
            return -2;
        default:
            break;
        }

        //Mover Monstruos
        for (int i = 0; i < personajes.size() - 1; i++) {
            Posicion pA = personajes.get(i).getPos();
            Posicion pS = personajes.get(i).move(pA, dir);
            if (getElemento(pS).getImagen() == ' ') {
                personajes.get(i).setPos(pS);
                setElemento(personajes.get(i), pS); // movemos al heroe
                setElemento(new LugarHab(), pA); // vaciamos su antigua posicion
            }
        }

        if (isEnemigoCerca(p2)) {
            vidas--;
        }
        //Si no los hemos atrapados a todos y seguimos en la misma hab.
        if (vidas > 0) {
            return -1;
        } else {
            return -3; //Sino GAME OVER.
        }
    }

    /**
     * Busca enemigos alrededor de la posicion indicada.
     * @param p Posicion
     * @return true si tiene algun enemigo cerca (incluido diagonal) o
     * false en otro caso.
     */
    private boolean isEnemigoCerca(final Posicion p) {

        for (int i = p.getRow() - 1; i <= p.getRow() + 1; i++) {
            for (int j = p.getCol() - 1; j <= p.getCol() + 1; j++) {
                if (tablero[i][j].getImagen() == 'K') {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @return the vidas
     */
    public static final int getVidas() {
        return vidas;
    }

    /**
     * @param vidas the vidas to set
     */
    public static final void setVidas(int vidas) {
        MarioHab.vidas = vidas;
    }

}

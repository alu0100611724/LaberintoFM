
package prodconcretos;

import complementos.Posicion;
import productos.Habitacion;
import productos.LugarHab;
import productos.Personaje;
import productos.Puerta;

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
     * @return -1 => misma habitacion, -2 => game over, -3 => You Win y en
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
            return -3;
        default:
            break;
        }

        if (isEnemigoCerca(p2)) {
            vidas--;
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

        //Si no los hemos atrapados a todos y seguimos en la misma hab.
        if (vidas > 0) {
            return -1;
        } else {
            return -2; //Sino GAME OVER.
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
                if (tablero[i][j].getImagen() == 'F') {
                    return true;
                }
            }
        }
        return false;
    }
}

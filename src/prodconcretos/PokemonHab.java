
package prodconcretos;

import complementos.NumAleatorio;
import complementos.Posicion;
import productos.Habitacion;
import productos.LugarHab;
import productos.Personaje;
import productos.Puerta;

/**
 * @author Mauri
 *
 */
public class PokemonHab extends Habitacion {

    private static int pokemonCont = 0;

    public PokemonHab(int size) {
        super(size);
    }

    @Override
    public final void addPersonaje(final Personaje p) {
        NumAleatorio n = new NumAleatorio(tam - 1);
        int i = n.next();
        int j = n.next();
        while (tablero[i][j].getImagen() != ' ') {
            i = n.next();
            j = n.next();
        }
        Posicion posicion = new Posicion(i, j);
        p.setPos(posicion);
        personajes.add(p);
        setElemento(p, posicion);
        if (p.getImagen() == 'P') {
            pokemonCont++;
        }
    }

    /**
     * 
     * @param dir
     * @return
     */
    @Override
    public final int play(char dir) {

        //Mover HEROE
        Personaje heroe = personajes.get(personajes.size() - 1);
        Posicion p1 = heroe.getPos();
        Posicion p2 = heroe.move(p1, dir);

        switch (getElemento(p2).getImagen()) {
        case 'P': // si es un pokemon
            personajes.remove(getElemento(p2));
            pokemonCont--;
        case ' ': //si es vacion
            heroe.setPos(p2);
            setElemento(heroe, p2); // movemos al heroe
            setElemento(new LugarHab(), p1); // vaciamos su antigua posicion.
            break;
        case '#': // si es una puerta
            return (((Puerta) getElemento(p2)).getOtroLadoPuerta());
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

        //Si no los hemos atrapados a todos y seguimos en la misma hab.
        if (pokemonCont > 0) {
            return -1;
        } else {
            return -2; //Si ganamos.
        }
    }
}

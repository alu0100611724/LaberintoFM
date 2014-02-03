
package modelo.productos.concretos;

import modelo.complementos.NumAleatorio;
import modelo.complementos.Posicion;
import modelo.productos.Habitacion;
import modelo.productos.LugarHab;
import modelo.productos.Pared;
import modelo.productos.Personaje;
import modelo.productos.Puerta;

/**
 * @author Mauri
 *
 */
public class PokemonHab extends Habitacion {

    /**
     * Contador de Pokemons.
     */
    private static int pokemonCont = 0;

    /**
     * Constructor.
     * @param size Tamano de la habitacion (cuadrada).
     */
    public PokemonHab(final int size) {
        super(size);
        tablero = new LugarHab[tam][tam];
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                if ((i != 0) && (j != 0) && (i != tam - 1) && (j != tam - 1)) {
                    tablero[i][j] = new LugarHab();
                } else {
                    Pared p = new Pared();
                    p.setRutaImg("images/paredPokemon.png");
                    tablero[i][j] = p;
                }
            }
        }
    }

    /**
     * Agrega 4 puertas a la habitacion.
     */
    public final void addPuertas() {
        Puerta p = new Puerta();
        p.setRutaImg("images/puertaPokemon.png");
        tablero[tam / 2][tam - 1] = p;
        tablero[tam / 2][0] = p;
        tablero[tam - 1][tam / 2] = p;
        tablero[0][tam / 2] = p;
    }
    /**
     * Agregar Personaje.
     * Si se agrega un pokemon, se incrementa el contador.
     * @param Personaje.
     */
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
        } else if (p.getImagen() == '@') {
            p.setRutaImg("images/ash.png");
        }
    }

    /**
     * Metodo Play.
     * Establece las reglas del juego.
     * @param dir Direccion a la que se desea mover.
     * @return -1 => misma habitacion, -2 => You Win y en
     * otro caso el id de la nueva habitacionActual.
     */
    @Override
    public final int play(final char dir) {

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

    /**
     * @return the pokemonCont
     */
    public static final int getPokemonCont() {
        return pokemonCont;
    }

    /**
     * @param pokemonCont the pokemonCont to set
     */
    public static final void setPokemonCont(int pokemonCont) {
        PokemonHab.pokemonCont = pokemonCont;
    }

}

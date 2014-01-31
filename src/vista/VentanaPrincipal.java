package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import modelo.builder.Builder;
import modelo.builder.Director;
import modelo.productos.Laberinto;


/**
 * Ventana Principal de la Aplicacion.
 * @author Mauri
 *
 */
public class VentanaPrincipal extends JFrame {

    //----------------------------------------
    // CONSTANTES
    //----------------------------------------
    static final String TITULO = "MazeMaker";
    static final int ANCHO_BORDES = 10;

    //----------------------------------------
    // ATRIBUTOS
    //----------------------------------------
    private Builder builder;
    private Director director;
    private Laberinto laberinto;

    private JButton bObjetivo;
    private JButton bCambiar;
    private JButton bGuardar;
    private JButton bCargar;
    private JButton bAbout;
    private JButton bSalir;

    //----------------------------------------
    // CONSTRUCTORES
    //----------------------------------------
    /**
     * Construye La ventana con los valores por defecto.
     */
    public VentanaPrincipal() {
        super(TITULO);
        inicializar();
    }

    /**
     * Construya la ventana principal con los valores deseados.
     * @param titulo Nombre de la ventana.
     */
    public VentanaPrincipal(final String titulo) {
        super(titulo);
        inicializar();
    }

    //----------------------------------------
    // METODOS PUBLICOS
    //----------------------------------------
    /**
     * Metodo principal, llamado por defecto que crea la ventana.
     * @param args Argumentos.
     */
    public static void main(final String[] args) {
        new VentanaPrincipal();
    }

    //----------------------------------------
    // METODOS PRIVADOS
    //----------------------------------------
    /**
     * Metodo encargado de construir la ventana.
     */
    private void inicializar() {
        setLayout(new BorderLayout(ANCHO_BORDES, ANCHO_BORDES));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);

        // Panel Botones
        JPanel pMenu = new JPanel();
        pMenu.setLayout(new GridLayout(6, 1));
        pMenu.add(bObjetivo = new JButton("Objetivos"));
        pMenu.add(bCambiar = new JButton("Cambiar Laberinto"));
        pMenu.add(bGuardar = new JButton("Guardar"));
        pMenu.add(bCargar = new JButton("Cargar"));
        pMenu.add(bAbout = new JButton("About MazeMaker"));
        pMenu.add(bSalir = new JButton("Salir"));

        // Panel Habitacion
        JPanel pHabitacion = new JPanel();
        pHabitacion.setLayout(new GridLayout(10, 10, 0, 0)); // cambiar por tamHabitacion
        pHabitacion.setBorder(new TitledBorder("Mario Bros."));
        for (int i = 0; i < 100; i++) {
          pHabitacion.add(new JLabel("" + i)); // Add imagen de cada elemento de la habitacion
        }

        // Panel que indica el Estado del juego.
        JPanel pEstadoJuego = new JPanel();
        pEstadoJuego.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
        pEstadoJuego.add(new JLabel("Vidas: ")); // Cambia vidas por pokemons de acuerdo al modo de juego
        pEstadoJuego.add(new JLabel("X"));

        // Panel que combina la habitacion con el estado del juego
        JPanel pJuego = new JPanel();
        pJuego.setLayout(new BorderLayout());
        pJuego.add(pHabitacion, BorderLayout.CENTER);
        pJuego.add(pEstadoJuego, BorderLayout.SOUTH);

        // Agregar paneles a la ventana
        add(pMenu, BorderLayout.WEST);
        add(pJuego, BorderLayout.CENTER);

        // Ajustar tamano de la ventana al contenido
        pack();

        // Listeners (Actions & Keys)

        /* Listener boton crear:
         * 1. crea intancia un panelConfigLab y le pasa por parametro this
         * 2. La pone visible
         * 3. le asigna focus
         */
    }

    //----------------------------------------
    // GETTERS Y SETTERS
    //----------------------------------------
    /**
     * @return the builder
     */
    public final Builder getBuilder() {
        return builder;
    }

    /**
     * @param builder the builder to set
     */
    public final void setBuilder(final Builder builder) {
        this.builder = builder;
    }

    /**
     * @return the director
     */
    public final Director getDirector() {
        return director;
    }

    /**
     * @param director the director to set
     */
    public final void setDirector(final Director director) {
        this.director = director;
    }

    /**
     * @return the laberinto
     */
    public final Laberinto getLaberinto() {
        return laberinto;
    }

    /**
     * @param laberinto the laberinto to set
     */
    public final void setLaberinto(final Laberinto laberinto) {
        this.laberinto = laberinto;
    }

}

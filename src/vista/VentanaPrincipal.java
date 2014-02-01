package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import modelo.builder.Builder;
import modelo.builder.Director;
import modelo.builder.JuegoMarioLabBuilder;
import modelo.complementos.Posicion;
import modelo.productos.Laberinto;


/**
 * Ventana Principal de la Aplicacion.
 * Esta formada por un menu y un panel de juego.
 * @author Mauri
 *
 */
public class VentanaPrincipal extends JFrame {

    //----------------------------------------
    // CONSTANTES
    //----------------------------------------
    /**
     * Titulo por defecto de la ventana.
     */
    static final String TITULO = "MazeMaker";
    static final int ANCHO_BORDES = 10;

    //----------------------------------------
    // ATRIBUTOS
    //----------------------------------------
    private Builder builder;
    private Director director;
    private Laberinto laberinto;
    private int contHabs;

    private PanelConfigLab pCL;
    private PanelConfigHab pCH;
    private PanelConfigConexiones pCC;

    private JPanel pJuego;
    private JPanel pHabitacion;
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
        Builder b = new JuegoMarioLabBuilder();
        Director d = new Director(b);
        try {
            laberinto = d.cargarPredeterminado();
        } catch (Exception e) {
            e.printStackTrace();
        }
        contHabs = 1;
        inicializar();
        //laberinto.play();
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

    /**
     * Reinicia los paneles, obtiene el nuevo laberinto y lo pinta.
     */
    public final void resetVentanas() {
        laberinto = director.getBuilder().getLab();
        contHabs = 1;
        pCL.dispose();
        pCH.dispose();
        pCC.dispose();
        pCL = new PanelConfigLab(this);
        pCH = new PanelConfigHab(this);
        pCC = new PanelConfigConexiones(this);
        repaint();
    }

    public final void pintarLab(JPanel pHab) {
        int tamHabActual = laberinto.getHabI(laberinto.getHabActual()).getTam();
        pHab.setLayout(new GridLayout(tamHabActual, tamHabActual, 0, 0));
        pHab.setBorder(new TitledBorder("Mario Bros."));
        for (int i = 0; i < tamHabActual; i++) {
            for (int j = 0; j < tamHabActual; j++) {
                pHab.add(new JLabel("" + laberinto.pintarVentana(i, j)));
            }
        }
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

        pCL = new PanelConfigLab(this);
        pCH = new PanelConfigHab(this);
        pCC = new PanelConfigConexiones(this);

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
        pHabitacion = new JPanel();
        pintarLab(pHabitacion);

        // Panel que indica el Estado del juego.
        JPanel pEstadoJuego = new JPanel();
        pEstadoJuego.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
        pEstadoJuego.add(new JLabel("Vidas: ")); // Cambia vidas por pokemons de acuerdo al modo de juego
        pEstadoJuego.add(new JLabel("X"));

        // Panel que combina la habitacion con el estado del juego
        pJuego = new JPanel();
        pJuego.setLayout(new BorderLayout());
        pJuego.add(pHabitacion, BorderLayout.CENTER);
        pJuego.add(pEstadoJuego, BorderLayout.SOUTH);

        // Agregar paneles a la ventana
        add(pMenu, BorderLayout.WEST);
        add(pJuego, BorderLayout.CENTER);

        // Ajustar tamano de la ventana al contenido
        pack();

        // Listeners (Actions & Keys)
        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                  case KeyEvent.VK_DOWN: laberinto.play('s');
                  laberinto.pintar();
                  break;
                  case KeyEvent.VK_UP: laberinto.play('w');
                  laberinto.pintar();
                  break;
                  case KeyEvent.VK_LEFT: laberinto.play('a');
                  laberinto.pintar();
                  break;
                  case KeyEvent.VK_RIGHT: laberinto.play('d');
                  laberinto.pintar();
                  break;
                  default: //do nothing
                }
                pJuego.removeAll();
                pHabitacion = new JPanel();
                pintarLab(pHabitacion);
                JPanel pEstadoJuego = new JPanel();
                pEstadoJuego.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
                pEstadoJuego.add(new JLabel("Vidas: ")); // Cambia vidas por pokemons de acuerdo al modo de juego
                pEstadoJuego.add(new JLabel("X"));
                pJuego.add(pHabitacion, BorderLayout.CENTER);
                pJuego.add(pEstadoJuego, BorderLayout.SOUTH);
                validate();
            }
        });

        bCambiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
              pCL.setVisible(true);
            }
        });

        bSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
              dispose();
            }
        });
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
    public final void setBuilder(Builder builder) {
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
    public final void setDirector(Director director) {
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
    public final void setLaberinto(Laberinto laberinto) {
        this.laberinto = laberinto;
    }

    /**
     * @return the pCL
     */
    public final PanelConfigLab getpCL() {
        return pCL;
    }

    /**
     * @param pCL the pCL to set
     */
    public final void setpCL(PanelConfigLab pCL) {
        this.pCL = pCL;
    }

    /**
     * @return the pCH
     */
    public final PanelConfigHab getpCH() {
        return pCH;
    }

    /**
     * @param pCH the pCH to set
     */
    public final void setpCH(PanelConfigHab pCH) {
        this.pCH = pCH;
    }

    /**
     * @return the pCC
     */
    public final PanelConfigConexiones getpCC() {
        return pCC;
    }

    /**
     * @param pCC the pCC to set
     */
    public final void setpCC(PanelConfigConexiones pCC) {
        this.pCC = pCC;
    }

    /**
     * @return the contHabs
     */
    public final int getContHabs() {
        return contHabs;
    }

    /**
     * @param contHabs the contHabs to set
     */
    public final void setContHabs(int contHabs) {
        this.contHabs = contHabs;
    }

    /**
     * @return the pHabitacion
     */
    public final JPanel getPHabitacion() {
        return pHabitacion;
    }

    /**
     * @param pHabitacion the pHabitacion to set
     */
    public final void setPHabitacion(JPanel pHabitacion) {
        this.pHabitacion = pHabitacion;
    }

}

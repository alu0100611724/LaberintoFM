package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controlador.ControladorVP;
import modelo.builder.Builder;
import modelo.builder.Director;
import modelo.builder.JuegoMarioLabBuilder;
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

    private ControladorVP cVP;
    private PanelConfigLab pCL;
    private PanelConfigHab pCH;
    private PanelConfigConexiones pCC;
    private VentanaAbout vA;

    private JPanel pJuego;
    private JPanel pHabitacion;
    private JButton bReset;
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
        cVP = new ControladorVP(this);
        inicializar();
        //laberinto.play();
    }
    public VentanaPrincipal(Director dir, Laberinto lab) {
        super(TITULO);
        director = dir;
        builder = dir.getBuilder();
        laberinto = lab;
        contHabs = 1;
        cVP = new ControladorVP(this);
        inicializar();
        //laberinto.play();
    }

    /**
     * Construye La ventana con los valores por defecto.
     */
    public VentanaPrincipal(Director dir) {
        super(TITULO);
        director = dir;
        builder = dir.getBuilder();
        laberinto = builder.getLab();
        contHabs = 1;
        cVP = new ControladorVP(this);
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
        vA = new VentanaAbout();
        validate();
    }

    /**
     * Metodo para pintar la habitacion en la ventana.
     * @param pHab Panel donde se pinta la habitacion
     */
    public final void pintarLab(JPanel pHab) {
        int tamHabActual = laberinto.getHabI(laberinto.getHabActual()).getTam();
        pHab.setLayout(new GridLayout(tamHabActual, tamHabActual, 0, 0));
        pHab.setBorder(new TitledBorder("Habitacion 0"
                                        + (laberinto.getHabActual() + 1)));
        for (int i = 0; i < tamHabActual; i++) {
            for (int j = 0; j < tamHabActual; j++) {
                ImageIcon img = new ImageIcon(laberinto.pintarVentana(i, j));
                pHab.add(new JLabel(img));
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
        vA = new VentanaAbout();

        // Panel Botones
        JPanel pMenu = new JPanel();
        pMenu.setLayout(new GridLayout(6, 1));
        pMenu.add(bCambiar = new JButton("Cambiar Laberinto"));
        pMenu.add(bGuardar = new JButton("Guardar"));
        pMenu.add(bCargar = new JButton("Cargar"));
        pMenu.add(bReset = new JButton("Reiniciar"));
        pMenu.add(bAbout = new JButton("About MazeMaker"));
        pMenu.add(bSalir = new JButton("Salir"));

        // Panel Habitacion
        pHabitacion = new JPanel();
        pintarLab(pHabitacion);

        // Panel que indica el Estado del juego.
        JPanel pEstadoJuego = new JPanel();
        pEstadoJuego.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
        pEstadoJuego.add(new JLabel("¿Listo para Jugar?"));

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
        this.addKeyListener(cVP);
        bCambiar.addActionListener(cVP);
        bReset.addActionListener(cVP);
        bAbout.addActionListener(cVP);
        bSalir.addActionListener(cVP);
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

    /**
     * @return the pJuego
     */
    public final JPanel getPJuego() {
        return pJuego;
    }

    /**
     * @param pJuego the pJuego to set
     */
    public final void setPJuego(JPanel pJuego) {
        this.pJuego = pJuego;
    }
    /**
     * @return the bReset
     */
    public final JButton getbReset() {
        return bReset;
    }
    /**
     * @param bReset the bReset to set
     */
    public final void setbReset(JButton bReset) {
        this.bReset = bReset;
    }
    /**
     * @return the bCambiar
     */
    public final JButton getbCambiar() {
        return bCambiar;
    }
    /**
     * @param bCambiar the bCambiar to set
     */
    public final void setbCambiar(JButton bCambiar) {
        this.bCambiar = bCambiar;
    }
    /**
     * @return the bGuardar
     */
    public final JButton getbGuardar() {
        return bGuardar;
    }
    /**
     * @param bGuardar the bGuardar to set
     */
    public final void setbGuardar(JButton bGuardar) {
        this.bGuardar = bGuardar;
    }
    /**
     * @return the bCargar
     */
    public final JButton getbCargar() {
        return bCargar;
    }
    /**
     * @param bCargar the bCargar to set
     */
    public final void setbCargar(JButton bCargar) {
        this.bCargar = bCargar;
    }
    /**
     * @return the bAbout
     */
    public final JButton getbAbout() {
        return bAbout;
    }
    /**
     * @param bAbout the bAbout to set
     */
    public final void setbAbout(JButton bAbout) {
        this.bAbout = bAbout;
    }
    /**
     * @return the bSalir
     */
    public final JButton getbSalir() {
        return bSalir;
    }
    /**
     * @param bSalir the bSalir to set
     */
    public final void setbSalir(JButton bSalir) {
        this.bSalir = bSalir;
    }
    /**
     * @return the cVP
     */
    public final ControladorVP getcVP() {
        return cVP;
    }
    /**
     * @param cVP the cVP to set
     */
    public final void setcVP(ControladorVP cVP) {
        this.cVP = cVP;
    }
    /**
     * @return the vA
     */
    public final VentanaAbout getvA() {
        return vA;
    }
    /**
     * @param vA the vA to set
     */
    public final void setvA(VentanaAbout vA) {
        this.vA = vA;
    }

}

package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;


/**
 * Ventana Principal de la Aplicacion.
 * @author Mauri
 *
 */
public class VentanaPrincipal extends JFrame {

    //----------------------------------------
    // CONSTANTES
    //----------------------------------------
    static final int ANCHO_VENT = 235;
    static final int ALTO_VENT = 340;
    static final String TITULO = "MazeMaker";
    /**
     * NUmero de espacios definido entre elementos.
     */
    static final int ANCHO_BORDES = 30;

    //----------------------------------------
    // ATRIBUTOS
    //----------------------------------------
    private JButton bJugar;
    private JButton bCrear;
    private JButton bCargar;
    private JButton bSalir;

    //----------------------------------------
    // GETTERS Y SETTERS
    //----------------------------------------
    /**
     * @return the botonJugar
     */
    public final JButton getBotonJugar() {
        return bJugar;
    }

    /**
     * @param botonJugar the botonJugar to set
     */
    public final void setBotonJugar(final JButton botonJugar) {
        this.bJugar = botonJugar;
    }

    /**
     * @return the botonCrear
     */
    public final JButton getBotonCrear() {
        return bCrear;
    }

    /**
     * @param botonCrear the botonCrear to set
     */
    public final void setBotonCrear(final JButton botonCrear) {
        this.bCrear = botonCrear;
    }

    /**
     * @return the botonCargar
     */
    public final JButton getBotonCargar() {
        return bCargar;
    }

    /**
     * @param botonCargar the botonCargar to set
     */
    public final void setBotonCargar(final JButton botonCargar) {
        this.bCargar = botonCargar;
    }

    /**
     * @return the botonSalir
     */
    public final JButton getBotonSalir() {
        return bSalir;
    }

    /**
     * @param botonSalir the botonSalir to set
     */
    public final void setBotonSalir(final JButton botonSalir) {
        this.bSalir = botonSalir;
    }

    //----------------------------------------
    // CONSTRUCTORES
    //----------------------------------------
    /**
     * Construye La ventana con los valores por defecto.
     */
    public VentanaPrincipal() {
        super(TITULO);
        inicializar(ANCHO_VENT, ALTO_VENT);
    }

    /**
     * Construye la ventana con un alto y ancho determinado.
     * @param ancho Numero de pixeles de ancho.
     * @param alto Numero de pixeles de alto.
     */
    public VentanaPrincipal(final int ancho, final int alto) {
        super(TITULO);
        inicializar(ancho, alto);
    }
    /**
     * Construya la ventana principal con los valores deseados.
     * @param ancho Numero de pixeles de ancho.
     * @param alto Numero de pixeles de alto.
     * @param titulo Nombre de la ventana.
     */
    public VentanaPrincipal(final int ancho, final int alto,
                            final String titulo) {
        super(titulo);
        inicializar(ancho, alto);
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
     * @param ancho Numero de pixeles de ancho.
     * @param alto Numero de pixeles de alto.
     */
    private void inicializar (final int ancho, final int alto) {
        setLayout(null);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setSize(ancho, alto + 50);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible (true);

        setBotonJugar(new JButton("Modo Historia"));
        getBotonJugar().setLocation(ANCHO_BORDES + 20, ANCHO_BORDES);
        getBotonJugar().setSize(130, 50);
        getBotonJugar().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent arg0) {
             dispose();
           }
         });
        add(getBotonJugar());

        setBotonCrear(new JButton("Crear Laberinto"));
        getBotonCrear().setLocation(ANCHO_BORDES + 20, getBotonJugar().getY()
                                + getBotonJugar().getHeight() + ANCHO_BORDES);
        getBotonCrear().setSize(130, 50);
        getBotonCrear().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent arg0) {
             dispose();
           }
         });
        add(getBotonCrear());

        setBotonCargar(new JButton("Cargar Partida"));
        getBotonCargar().setLocation(ANCHO_BORDES + 20, getBotonCrear().getY()
                                + getBotonCrear().getHeight() + ANCHO_BORDES);
        getBotonCargar().setSize(130, 50);
        getBotonCargar().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent arg0) {
             dispose();
           }
         });
        add(getBotonCargar());

        setBotonSalir(new JButton("Salir"));
        getBotonSalir().setLocation(ANCHO_BORDES + 20, getBotonCargar().getY()
                            + getBotonCargar().getHeight() + ANCHO_BORDES);
        getBotonSalir().setSize(130, 50);
        getBotonSalir().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent arg0) {
             dispose();
           }
         });
        add(getBotonSalir());
    }
}
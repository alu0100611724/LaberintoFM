package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

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
    static final int ANCHO_BORDES = 30;

    //----------------------------------------
    // ATRIBUTOS
    //----------------------------------------
    private JButton botonJugar;
    private JButton botonCrear;
    private JButton botonCargar;
    private JButton botonSalir;

    //----------------------------------------
    // GETTERS Y SETTERS
    //----------------------------------------
    /**
     * @return the botonJugar
     */
    public final JButton getBotonJugar() {
        return botonJugar;
    }

    /**
     * @param botonJugar the botonJugar to set
     */
    public final void setBotonJugar(JButton botonJugar) {
        this.botonJugar = botonJugar;
    }

    /**
     * @return the botonCrear
     */
    public final JButton getBotonCrear() {
        return botonCrear;
    }

    /**
     * @param botonCrear the botonCrear to set
     */
    public final void setBotonCrear(JButton botonCrear) {
        this.botonCrear = botonCrear;
    }

    /**
     * @return the botonCargar
     */
    public final JButton getBotonCargar() {
        return botonCargar;
    }

    /**
     * @param botonCargar the botonCargar to set
     */
    public final void setBotonCargar(JButton botonCargar) {
        this.botonCargar = botonCargar;
    }

    /**
     * @return the botonSalir
     */
    public final JButton getBotonSalir() {
        return botonSalir;
    }

    /**
     * @param botonSalir the botonSalir to set
     */
    public final void setBotonSalir(JButton botonSalir) {
        this.botonSalir = botonSalir;
    }

    //----------------------------------------
    // CONSTRUCTORES
    //----------------------------------------
    public VentanaPrincipal () {
        super (TITULO);
        inicializar (ANCHO_VENT, ALTO_VENT);
    }

    public VentanaPrincipal (final int ancho, final int alto) {
        super (TITULO);
        inicializar (ancho, alto);
    }
    public VentanaPrincipal (final int ancho, final int alto, final String titulo) {
        super (titulo);
        inicializar (ancho, alto);
    }

    //----------------------------------------
    // METODOS PUBLICOS
    //----------------------------------------
    public static void main(String[] args) {
        new VentanaPrincipal ();
    }

    //----------------------------------------
    // METODOS PRIVADOS
    //----------------------------------------
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
               /*
             getLaVentana_().getLaRefZonaTrabajo_().nuevaVentanaInterna(10, 10, getLaImagenResultado_());
             getLaVentana_().getLaRefZonaTrabajo_()
                .getVecVentanas_().lastElement()
                .getElHistograma_().getElHistograma_()[0] -= getLasHerramientas_().getContadorDeFondo();
             try {
               getLaVentana_().getLaRefZonaTrabajo_().getVecVentanas_().lastElement().setSelected(true);
             } catch (PropertyVetoException e) {
               e.printStackTrace();
             }
             dispose();*/
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
               /*
             getLaVentana_().getLaRefZonaTrabajo_().nuevaVentanaInterna(10, 10, getLaImagenResultado_());
             getLaVentana_().getLaRefZonaTrabajo_()
                .getVecVentanas_().lastElement()
                .getElHistograma_().getElHistograma_()[0] -= getLasHerramientas_().getContadorDeFondo();
             try {
               getLaVentana_().getLaRefZonaTrabajo_().getVecVentanas_().lastElement().setSelected(true);
             } catch (PropertyVetoException e) {
               e.printStackTrace();
             }
             dispose();*/
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
               /*
             getLaVentana_().getLaRefZonaTrabajo_().nuevaVentanaInterna(10, 10, getLaImagenResultado_());
             getLaVentana_().getLaRefZonaTrabajo_()
                .getVecVentanas_().lastElement()
                .getElHistograma_().getElHistograma_()[0] -= getLasHerramientas_().getContadorDeFondo();
             try {
               getLaVentana_().getLaRefZonaTrabajo_().getVecVentanas_().lastElement().setSelected(true);
             } catch (PropertyVetoException e) {
               e.printStackTrace();
             }
             dispose();*/
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
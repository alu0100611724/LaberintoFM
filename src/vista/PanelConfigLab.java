
package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Panel de Configuracion del laberinto.
 * Selecciona el tipo de laberinto y el numero de habitaciones.
 * @author Mauri
 *
 */
public class PanelConfigLab extends JFrame {

    //----------------------------------------
    // CONSTANTES
    //----------------------------------------
    /**
     * Nombre de la ventana por defecto.
     */
    static final String TITULO = "Maze Settings";


    //----------------------------------------
    // ATRIBUTOS
    //----------------------------------------
    private JRadioButton rbMario, rbPokemon;
    private JButton bCancelar, bSiguiente;
    private JSlider sNumHabs;
    private JLabel lNumHabs;
    /**
     * Ventana Principal
     */
    private VentanaPrincipal vp;

    //----------------------------------------
    // CONSTRUCTORES
    //----------------------------------------
    /**
     * Construye Panel de Configuracion del Laberinto.
     * Este constructor es el que se llama desde la Ventana Principal.
     * @param vPrincipal Recibe la ventana principal.
     */
    public PanelConfigLab(final VentanaPrincipal vPrincipal) {
        super(TITULO);
        vp = vPrincipal;
        inicializar();
    }

    /**
     * Construye Panel de Configuracion del Laberinto.
     * Este constructor es utilizado para pruebas de diseño.
     */
    public PanelConfigLab() {
        super(TITULO);
        vp = new VentanaPrincipal();
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
        new PanelConfigLab();
    }

    //----------------------------------------
    // METODOS PRIVADOS
    //----------------------------------------
    /**
     * Construye una ventana compuesta de 3 paneles.
     */
    private void inicializar() {

        // Configuracion Ventana
        setLayout(new GridLayout(3, 1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        // Creando Panel para los radio buttons utilizando GridLayout
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 2));
        p1.add(rbMario = new JRadioButton("Mario Bros"));
        p1.add(rbPokemon = new JRadioButton("Pokemon"));
        p1.setBorder(new TitledBorder("Modo de Juego"));

        // Creando un grupo de radio buttons
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(rbMario);
        grupo.add(rbPokemon);

        // Set keyboard mnemonics
        rbMario.setMnemonic('M');
        rbPokemon.setMnemonic('P');

        // Fijamos modo mario por defecto
        rbMario.setSelected(true);

        // Crea Panel para el slider utilizando BorderLayout
        JPanel p2 = new JPanel();
        p2.setLayout(new BorderLayout(15, 15));
        sNumHabs = new JSlider(1, 10, 1);
        sNumHabs.setMajorTickSpacing(1);
        sNumHabs.setPaintTicks(true);
        lNumHabs = new JLabel();
        lNumHabs.setText("0" + String.valueOf(sNumHabs.getValue()));
        p2.add(sNumHabs, BorderLayout.CENTER);
        p2.add(lNumHabs, BorderLayout.EAST);
        p2.setBorder(new TitledBorder("Numero de Habitaciones"));

        // Crea Panel para los botones con FlowLayout
        JPanel p3 = new JPanel();
        p3.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 25));
        p3.add(bCancelar = new JButton("Cancelar"));
        p3.add(bSiguiente = new JButton("Siguiente"));

        // Set listeners
        sNumHabs.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent arg0) {
                if (sNumHabs.getValue() < 10) {
                    lNumHabs.setText("0"
                                + String.valueOf(sNumHabs.getValue()));
                } else {
                    lNumHabs.setText(String.valueOf(sNumHabs.getValue()));
                }
            }
        });

        bCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
              dispose();
              // Abrir Ventana principal
            }
        });

        bSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
              /* Si rb Mario creamos laberinto mario con n habitaciones
               * sino creamos laberinto pokemon
               * llamamos a la siguiente ventana pasando como argumento vp
               * cerramos ventana actual
               */
            }
        });

        // Agregando Paneles
        add(p1);
        add(p2);
        add(p3);

        // Ajusta el tamano de la ventana a su contenido.
        pack();
    }
}

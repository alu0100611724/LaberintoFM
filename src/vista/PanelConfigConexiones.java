
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
 * Panel de configuracion de Las comunicaciones entre las habitaciones.
 * @author Mauri
 *
 */
public class PanelConfigConexiones extends JFrame {
  //----------------------------------------
    // CONSTANTES
    //----------------------------------------
    static final String TITULO = "Conexiones";

    //----------------------------------------
    // ATRIBUTOS
    //----------------------------------------
    /**
     * Ventana Principal de la Aplicacion.
     */
    private VentanaPrincipal vp;

    private JRadioButton oN, oS, oE, oO, dN, dS, dE, dO;
    private JSlider sHabO, sHabD;
    private JLabel lHabO, lHabD;
    private JButton bOtra, bFin;

    //----------------------------------------
    // CONSTRUCTORES
    //----------------------------------------
    /**
     * Construtor de Panel de Configuracion de las Conexiones entre puertas.
     * Este es utilizado para el dise�o del panel.
     */
    public PanelConfigConexiones() {
        super(TITULO);
        vp = new VentanaPrincipal();
        inicializar();
    }

    /**
     * Construtor de Panel de Configuracion de las Conexiones entre puertas.
     * @param vPrincipal Ventana Principal.
     */
    public PanelConfigConexiones(VentanaPrincipal vPrincipal) {
        super(TITULO);
        vp = vPrincipal;
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
        new PanelConfigConexiones();
    }

    /**
     * Modifica el tamano max del slider.
     * @param valorMaxSlider
     */
    public void setMaxSHabO(int valorMaxSlider){
        sHabO.setMaximum(valorMaxSlider);
    }

    /**
     * Modifica el tamano max del slider.
     * @param valorMaxSlider
     */
    public void setMaxSHabD(int valorMaxSlider){
        sHabD.setMaximum(valorMaxSlider);
    }
    //----------------------------------------
    // METODOS PRIVADOS
    //----------------------------------------
    /**
     * Encargado de construir Panel de Configuracion de las Habitaciones.
     */
    private void inicializar() {
        // Configuracion Ventana
        setLayout(new GridLayout(5, 1, 10, 10));
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible (false);

        // Creando Panel Habitacion Origen utilizando BorderLayout
        JPanel p1 = new JPanel();
        p1.setLayout(new BorderLayout(15, 15));
        sHabO = new JSlider(1, 20, 1);
        sHabO.setMajorTickSpacing(1);
        sHabO.setPaintTicks(true);
        lHabO = new JLabel();
        lHabO.setText("0" + String.valueOf(sHabO.getValue()));
        p1.add(sHabO, BorderLayout.CENTER);
        p1.add(lHabO, BorderLayout.EAST);
        p1.setBorder(new TitledBorder("Habitacion Origen"));

        // Creando Panel para los radio buttons utilizando GridLayout
        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(1, 4, 10, 5));
        p2.add(oN = new JRadioButton("Norte"));
        p2.add(oS = new JRadioButton("Sur  "));
        p2.add(oE = new JRadioButton("Este "));
        p2.add(oO = new JRadioButton("Oeste"));
        p2.setBorder(new TitledBorder("Puerta Habitacion Origen"));

        // Creando un grupo de radio buttons
        ButtonGroup grupoOrigen = new ButtonGroup();
        grupoOrigen.add(oN);
        grupoOrigen.add(oS);
        grupoOrigen.add(oE);
        grupoOrigen.add(oO);

        // Creando Panel Habitacion Destino utilizando BorderLayout
        JPanel p3 = new JPanel();
        p3.setLayout(new BorderLayout(15, 15));
        sHabD = new JSlider(1, 20, 1);
        sHabD.setMajorTickSpacing(1);
        sHabD.setPaintTicks(true);
        lHabD = new JLabel();
        lHabD.setText("0" + String.valueOf(sHabD.getValue()));
        p3.add(sHabD, BorderLayout.CENTER);
        p3.add(lHabD, BorderLayout.EAST);
        p3.setBorder(new TitledBorder("Habitacion Destino"));

        // Creando Panel para los radio buttons utilizando GridLayout
        JPanel p4 = new JPanel();
        p4.setLayout(new GridLayout(1, 4, 10, 5));
        p4.add(dN = new JRadioButton("Norte"));
        p4.add(dS = new JRadioButton("Sur  "));
        p4.add(dE = new JRadioButton("Este "));
        p4.add(dO = new JRadioButton("Oeste"));
        p4.setBorder(new TitledBorder("Puerta Habitacion Destino"));

        // Creando un grupo de radio buttons
        ButtonGroup grupoDestino = new ButtonGroup();
        grupoDestino.add(dN);
        grupoDestino.add(dS);
        grupoDestino.add(dE);
        grupoDestino.add(dO);

        // Crea Panel para los botones con FlowLayout
        JPanel p5 = new JPanel();
        p5.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));
        bOtra = new JButton("Otra");
        bFin = new JButton("Fin ");
        p5.add(bOtra);
        p5.add(bFin);

        // Set listeners
        sHabO.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent arg0) {
                if (sHabO.getValue() < 10) {
                    lHabO.setText("0"
                                + String.valueOf(sHabO.getValue()));
                } else {
                    lHabO.setText(String.valueOf(sHabO.getValue()));
                }
            }
        });

        sHabD.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent arg0) {
                if (sHabD.getValue() < 10) {
                    lHabD.setText("0"
                                + String.valueOf(sHabD.getValue()));
                } else {
                    lHabD.setText(String.valueOf(sHabD.getValue()));
                }
            }
        });

        bFin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                //fijamos valores por defecto
                vp.getDirector().setPuertaOrigin(1);
                vp.getDirector().setPuertaDest(1);

                if (oN.isEnabled()) {
                    vp.getDirector().setPuertaOrigin(1);
                }
                if (oS.isEnabled()) {
                    vp.getDirector().setPuertaOrigin(2);
                }
                if (oE.isEnabled()) {
                    vp.getDirector().setPuertaOrigin(3);
                }
                if (oO.isEnabled()) {
                    vp.getDirector().setPuertaOrigin(4);
                }
                if (dN.isEnabled()) {
                    vp.getDirector().setPuertaDest(1);
                }
                if (dS.isEnabled()) {
                    vp.getDirector().setPuertaDest(2);
                }
                if (dE.isEnabled()) {
                    vp.getDirector().setPuertaDest(3);
                }
                if (dO.isEnabled()) {
                    vp.getDirector().setPuertaDest(4);
                }

                vp.getDirector().crearConexion((sHabO.getValue() - 1),
                        vp.getDirector().getPuertaOrigin(),
                        (sHabD.getValue() - 1),
                        vp.getDirector().getPuertaDest());
                vp.getDirector().habActual(0);
                vp.resetVentanas();
            }
        });

        // Agregando Paneles
        add(p1);
        add(p2);
        add(p3);
        add(p4);
        add(p5);

        // Fijamos puerta norte por defecto
        oN.setSelected(true);
        dN.setSelected(true);

        // Ajusta el tamano de la ventana a su contenido.
        pack();
    }
}



package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.border.TitledBorder;
import controlador.ControladorPCC;

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
    private ControladorPCC cPCC;

    private JRadioButton oN, oS, oE, oO, dN, dS, dE, dO;
    private JSlider sHabO, sHabD;
    private JLabel lHabO, lHabD;
    private JButton bOtra, bFin;

    //----------------------------------------
    // CONSTRUCTORES
    //----------------------------------------
    /**
     * Construtor de Panel de Configuracion de las Conexiones entre puertas.
     * Este es utilizado para el diseño del panel.
     */
    public PanelConfigConexiones() {
        super(TITULO);
        vp = new VentanaPrincipal();
        cPCC = new ControladorPCC(vp);
        inicializar();
    }

    /**
     * Construtor de Panel de Configuracion de las Conexiones entre puertas.
     * @param vPrincipal Ventana Principal.
     */
    public PanelConfigConexiones(VentanaPrincipal vPrincipal) {
        super(TITULO);
        vp = vPrincipal;
        cPCC = new ControladorPCC(vp);
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
        sHabO.addChangeListener(cPCC);
        sHabD.addChangeListener(cPCC);
        bFin.addActionListener(cPCC);
        bOtra.addActionListener(cPCC);

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

    //----------------------------------------
    // GETTERS Y SETTERS
    //----------------------------------------

    /**
     * @return the oN
     */
    public final JRadioButton getoN() {
        return oN;
    }

    /**
     * @param oN the oN to set
     */
    public final void setoN(JRadioButton oN) {
        this.oN = oN;
    }

    /**
     * @return the oS
     */
    public final JRadioButton getoS() {
        return oS;
    }

    /**
     * @param oS the oS to set
     */
    public final void setoS(JRadioButton oS) {
        this.oS = oS;
    }

    /**
     * @return the oE
     */
    public final JRadioButton getoE() {
        return oE;
    }

    /**
     * @param oE the oE to set
     */
    public final void setoE(JRadioButton oE) {
        this.oE = oE;
    }

    /**
     * @return the oO
     */
    public final JRadioButton getoO() {
        return oO;
    }

    /**
     * @param oO the oO to set
     */
    public final void setoO(JRadioButton oO) {
        this.oO = oO;
    }

    /**
     * @return the dN
     */
    public final JRadioButton getdN() {
        return dN;
    }

    /**
     * @param dN the dN to set
     */
    public final void setdN(JRadioButton dN) {
        this.dN = dN;
    }

    /**
     * @return the dS
     */
    public final JRadioButton getdS() {
        return dS;
    }

    /**
     * @param dS the dS to set
     */
    public final void setdS(JRadioButton dS) {
        this.dS = dS;
    }

    /**
     * @return the dE
     */
    public final JRadioButton getdE() {
        return dE;
    }

    /**
     * @param dE the dE to set
     */
    public final void setdE(JRadioButton dE) {
        this.dE = dE;
    }

    /**
     * @return the dO
     */
    public final JRadioButton getdO() {
        return dO;
    }

    /**
     * @param dO the dO to set
     */
    public final void setdO(JRadioButton dO) {
        this.dO = dO;
    }

    /**
     * @return the sHabO
     */
    public final JSlider getsHabO() {
        return sHabO;
    }

    /**
     * @param sHabO the sHabO to set
     */
    public final void setsHabO(JSlider sHabO) {
        this.sHabO = sHabO;
    }

    /**
     * @return the sHabD
     */
    public final JSlider getsHabD() {
        return sHabD;
    }

    /**
     * @param sHabD the sHabD to set
     */
    public final void setsHabD(JSlider sHabD) {
        this.sHabD = sHabD;
    }

    /**
     * @return the lHabO
     */
    public final JLabel getlHabO() {
        return lHabO;
    }

    /**
     * @param lHabO the lHabO to set
     */
    public final void setlHabO(JLabel lHabO) {
        this.lHabO = lHabO;
    }

    /**
     * @return the lHabD
     */
    public final JLabel getlHabD() {
        return lHabD;
    }

    /**
     * @param lHabD the lHabD to set
     */
    public final void setlHabD(JLabel lHabD) {
        this.lHabD = lHabD;
    }

    /**
     * @return the bOtra
     */
    public final JButton getbOtra() {
        return bOtra;
    }

    /**
     * @param bOtra the bOtra to set
     */
    public final void setbOtra(JButton bOtra) {
        this.bOtra = bOtra;
    }

    /**
     * @return the bFin
     */
    public final JButton getbFin() {
        return bFin;
    }

    /**
     * @param bFin the bFin to set
     */
    public final void setbFin(JButton bFin) {
        this.bFin = bFin;
    }

    /**
     * @return the cPCC
     */
    public final ControladorPCC getcPCC() {
        return cPCC;
    }

    /**
     * @param cPCC the cPCC to set
     */
    public final void setcPCC(ControladorPCC cPCC) {
        this.cPCC = cPCC;
    }

}


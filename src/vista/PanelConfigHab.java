
package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.TitledBorder;
import controlador.ControladorPCH;

/**
 * Esta ventana se llamara tantas veces como habitaciones se desee crear.
 * El usuario indica el tamano de la habitacion y los monstruos que contiene.
 * @author Mauri
 *
 */
public class PanelConfigHab extends JFrame {

      //----------------------------------------
      // CONSTANTES
      //----------------------------------------
      static final String TITULO = "Hab: 1";

      //----------------------------------------
      // ATRIBUTOS
      //----------------------------------------
      private VentanaPrincipal vp;
      private ControladorPCH cPCH;

      private JSlider sTam, sMonstruos;
      private JLabel lTam, lMonstruos;
      private JButton bCancelar, bSiguiente;

      //----------------------------------------
      // CONSTRUCTORES
      //----------------------------------------
      /**
       * Construtor de Panel de Configuracion de Habitaciones.
       * Este es utilizado para el diseño del panel.
       */
      public PanelConfigHab() {
          super(TITULO);
          cPCH = new ControladorPCH(vp);
          inicializar();
      }

      /**
       * Construtor de Panel de Configuracion de Habitaciones.
       * @param vPrincipal Ventana Principal.
       */
      public PanelConfigHab(VentanaPrincipal vPrincipal) {
          super(TITULO);
          vp = vPrincipal;
          cPCH = new ControladorPCH(vp);
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
          new PanelConfigHab();
      }

      //----------------------------------------
      // METODOS PRIVADOS
      //----------------------------------------
      /**
       * Encargado de construir Panel de Configuracion de las Habitaciones.
       */
      private void inicializar() {
          // Configuracion Ventana
          setLayout(new GridLayout(3, 1, 10, 15));
          setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
          setLocationRelativeTo(null);
          setResizable(false);
          setVisible (false);

          // Creando Panel Tamano Habitacion utilizando BorderLayout
          JPanel pTam = new JPanel();
          pTam.setLayout(new BorderLayout(15, 15));
          sTam = new JSlider(5, 20, 5);
          sTam.setMajorTickSpacing(1);
          sTam.setPaintTicks(true);
          lTam = new JLabel();
          lTam.setText("0" + String.valueOf(sTam.getValue()));
          pTam.add(sTam, BorderLayout.CENTER);
          pTam.add(lTam, BorderLayout.EAST);
          pTam.setBorder(new TitledBorder("Tamano de la Habitacion"));

          // Creando Panel Numero de Monstruos con BorderLayout
          JPanel pMonstruos = new JPanel();
          pMonstruos.setLayout(new BorderLayout(15, 15));
          sMonstruos = new JSlider(1, 3, 1);
          sMonstruos.setMajorTickSpacing(1);
          sMonstruos.setPaintTicks(true);
          lMonstruos = new JLabel();
          lMonstruos.setText("0" + String.valueOf(sMonstruos.getValue()));
          pMonstruos.add(sMonstruos, BorderLayout.CENTER);
          pMonstruos.add(lMonstruos, BorderLayout.EAST);
          pMonstruos.setBorder(new TitledBorder("Numero de Monstruos"));

          // Crea Panel para los botones con FlowLayout
          JPanel pBotones = new JPanel();
          pBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 25));
          bSiguiente = new JButton("Siguiente");
          bCancelar = new JButton("Cancelar");
          bCancelar.setSize(bSiguiente.getWidth(), bSiguiente.getHeight());
          pBotones.add(bCancelar);
          pBotones.add(bSiguiente);

          // Set listeners
          sTam.addChangeListener(cPCH);
          sMonstruos.addChangeListener(cPCH);
          bSiguiente.addActionListener(cPCH);
          bCancelar.addActionListener(cPCH);

          // Agregando Paneles
          add(pTam);
          add(pMonstruos);
          add(pBotones);

          // Ajusta el tamano de la ventana a su contenido.
          pack();
      }

    //----------------------------------------
    // GETTERS Y SETTERS
    //----------------------------------------

    /**
     * @return the sTam
     */
    public final JSlider getsTam() {
        return sTam;
    }

    /**
     * @param sTam the sTam to set
     */
    public final void setsTam(JSlider sTam) {
        this.sTam = sTam;
    }

    /**
     * @return the sMonstruos
     */
    public final JSlider getsMonstruos() {
        return sMonstruos;
    }

    /**
     * @param sMonstruos the sMonstruos to set
     */
    public final void setsMonstruos(JSlider sMonstruos) {
        this.sMonstruos = sMonstruos;
    }

    /**
     * @return the lTam
     */
    public final JLabel getlTam() {
        return lTam;
    }

    /**
     * @param lTam the lTam to set
     */
    public final void setlTam(JLabel lTam) {
        this.lTam = lTam;
    }

    /**
     * @return the lMonstruos
     */
    public final JLabel getlMonstruos() {
        return lMonstruos;
    }

    /**
     * @param lMonstruos the lMonstruos to set
     */
    public final void setlMonstruos(JLabel lMonstruos) {
        this.lMonstruos = lMonstruos;
    }

    /**
     * @return the bCancelar
     */
    public final JButton getbCancelar() {
        return bCancelar;
    }

    /**
     * @param bCancelar the bCancelar to set
     */
    public final void setbCancelar(JButton bCancelar) {
        this.bCancelar = bCancelar;
    }

    /**
     * @return the bSiguiente
     */
    public final JButton getbSiguiente() {
        return bSiguiente;
    }

    /**
     * @param bSiguiente the bSiguiente to set
     */
    public final void setbSiguiente(JButton bSiguiente) {
        this.bSiguiente = bSiguiente;
    }

    /**
     * @return the cPCH
     */
    public final ControladorPCH getcPCH() {
        return cPCH;
    }

    /**
     * @param cPCH the cPCH to set
     */
    public final void setcPCH(ControladorPCH cPCH) {
        this.cPCH = cPCH;
    }

  }


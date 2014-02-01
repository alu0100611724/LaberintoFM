
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
import javax.swing.JSlider;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
          inicializar();
      }

      /**
       * Construtor de Panel de Configuracion de Habitaciones.
       * @param vPrincipal Ventana Principal.
       */
      public PanelConfigHab(VentanaPrincipal vPrincipal) {
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
          sTam.addChangeListener(new ChangeListener() {
              @Override
              public void stateChanged(ChangeEvent arg0) {
                  if (sTam.getValue() < 10) {
                      lTam.setText("0" + String.valueOf(sTam.getValue()));
                  } else {
                      lTam.setText(String.valueOf(sTam.getValue()));
                  }
                  // Controlamos que no existan mas monstruos que vacios.
                  sMonstruos.setMaximum(sTam.getValue()-2);
              }
          });

          sMonstruos.addChangeListener(new ChangeListener() {
              @Override
              public void stateChanged(ChangeEvent arg0) {
                  if (sMonstruos.getValue() < 10) {
                      lMonstruos.setText("0"
                                  + String.valueOf(sMonstruos.getValue()));
                  } else {
                      lMonstruos.setText(String.valueOf(sMonstruos.getValue()));
                  }
              }
          });

          bSiguiente.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent arg0) {
                  if (vp.getContHabs() < vp.getDirector().getNumHabs()) {
                      vp.getDirector().crearHab(sTam.getValue(),
                              sMonstruos.getValue());
                      vp.getpCH().dispose();
                      vp.setContHabs(vp.getContHabs() + 1);
                      vp.setpCH(new PanelConfigHab(vp));
                      vp.getpCH().setTitle("Hab: " + vp.getContHabs());
                      vp.getpCH().setVisible(true);
                  } else {
                      vp.getDirector().crearHab(sTam.getValue(),
                              sMonstruos.getValue());
                      vp.getpCH().setVisible(false);
                      vp.getpCC().setVisible(true);
                  }

              }
          });

          bCancelar.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent arg0) {
                  dispose();
              }
          });

          // Agregando Paneles
          add(pTam);
          add(pMonstruos);
          add(pBotones);

          // Ajusta el tamano de la ventana a su contenido.
          pack();
      }
  }


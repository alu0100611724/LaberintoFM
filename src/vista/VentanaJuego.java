package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class VentanaJuego extends JFrame {

    //----------------------------------------
      // CONSTANTES
      //----------------------------------------
      static final int ANCHO_VENT = 235;
      static final int ALTO_VENT = 340;
      static final String TITULO = "MazeMaker";
      /**
       * Numero de espacios definido entre elementos.
       */
      static final int ANCHO_BORDES = 10;

      //----------------------------------------
      // ATRIBUTOS
      //----------------------------------------
      private JButton bEjemplo;

      //----------------------------------------
      // GETTERS Y SETTERS
      //----------------------------------------
      /**
       * @return the bEjemplo
       */
      public final JButton getBotonEjemplo() {
          return bEjemplo;
      }

      /**
       * @param bEjemplo the bEjemplo to set
       */
      public final void setBotonEjemplo(JButton botonEjemplo) {
          this.bEjemplo = botonEjemplo;
      }

      //----------------------------------------
      // CONSTRUCTORES
      //----------------------------------------
      /**
       * Construye La ventana con los valores por defecto.
       */
      public VentanaJuego() {
          super(TITULO);
          inicializar(ANCHO_VENT, ALTO_VENT);
      }

      /**
       * Construye la ventana con un alto y ancho determinado.
       * @param ancho Numero de pixeles de ancho.
       * @param alto Numero de pixeles de alto.
       */
      public VentanaJuego(final int ancho, final int alto) {
          super(TITULO);
          inicializar(ancho, alto);
      }
      /**
       * Construya la ventana principal con los valores deseados.
       * @param ancho Numero de pixeles de ancho.
       * @param alto Numero de pixeles de alto.
       * @param titulo Nombre de la ventana.
       */
      public VentanaJuego(final int ancho, final int alto,
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
          new VentanaJuego();
      }

      //----------------------------------------
      // METODOS PRIVADOS
      //----------------------------------------
      /**
       * Metodo encargado de construir la ventana.
       * @param ancho Numero de pixeles de ancho.
       * @param alto Numero de pixeles de alto.
       */
      private void inicializar(final int ancho, final int alto) {
          setLayout(null);
          setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
          setSize(ancho, alto + 50);
          setLocationRelativeTo(null);
          setResizable(false);
          setVisible (true);

          setBotonEjemplo(new JButton("Modo Historia"));
          getBotonEjemplo().setLocation(ANCHO_BORDES, ANCHO_BORDES);
          getBotonEjemplo().setSize(130, 50);
          getBotonEjemplo().addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent arg0) {
               dispose();
             }
           });
          add(getBotonEjemplo());
      }
  }

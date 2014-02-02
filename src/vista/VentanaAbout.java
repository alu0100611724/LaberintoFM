package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class VentanaAbout extends JFrame {

  //----------------------------------------
    // CONSTANTES
    //----------------------------------------
    /**
     * Titulo por defecto de la ventana.
     */
    static final String TITULO = "About MazeMaker";

    //----------------------------------------
    // CONSTRUCTORES
    //----------------------------------------
    /**
     * Construye La ventana con los valores por defecto.
     */
    public VentanaAbout() {
        super(TITULO);
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
        new VentanaAbout();
    }
    
    private void inicializar() {
        setLayout(new BorderLayout(10, 10));
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(false);

        String contenido = "\nMazeMaker - Version: 4.2.1\n\n" 
                + "MazeMaker es un framework que permite diseñar y construir\n"
                + "laberintos, para posteriormete, jugar en ellos.\n\n"
                + "Los laberintos estan formados por habitaciones con 4 purtas"
                + "\nque comunican o no con otra habitacion. Solo se mostrara"
                + "\nla abitacion actual en la que se encuentre el jugador.\n"
                + "\nSe incluyen dos tipos de laberintos como muestra:\n\n"
                + "- Laberinto Pokemon: Donde deberas que capturar todos los\n"
                + "pokemons salvajes para convertirte en un mastro pokemon.\n\n"
                + "- Laberinto Mario: Donde deberas rescatar a peach, evitando "
                + "\n  las koopas.\n\n"
                + "Autor: Maurizio A. Rendon M.\n";

        JTextArea texto = new JTextArea(contenido);
        texto.setEditable(false);
        add(texto, BorderLayout.CENTER);

        // Ajustar tamano de la ventana al contenido
        pack();
    }
}

package controlador;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

import vista.VentanaAbout;
import vista.VentanaPrincipal;
import modelo.builder.Director;
import modelo.productos.Laberinto;
import modelo.productos.concretos.MarioHab;
import modelo.productos.concretos.PokemonHab;

public class ControladorVP implements ActionListener, KeyListener {

    private VentanaPrincipal vp;

    public ControladorVP(VentanaPrincipal vPrincipal) {
        vp = vPrincipal;
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == vp.getbCambiar()) {
            vp.getpCL().setVisible(true);
        } else if (ae.getSource() == vp.getbReset()) {
            vp.dispose();
            VentanaPrincipal v = new VentanaPrincipal();
            v.setFocusable(true);
            v.revalidate();
        } else if (ae.getSource() == vp.getbCargar()) {
            JFileChooser selector = new JFileChooser(); 
            int retrival = selector.showOpenDialog(null);
            if (retrival == JFileChooser.APPROVE_OPTION) {
                try {
                    FileInputStream fis = new FileInputStream(selector.getSelectedFile());
                    ObjectInputStream entrada = new ObjectInputStream(fis);
                    Director d = (Director) entrada.readObject();
                    Laberinto l = (Laberinto) entrada.readObject();
                    
                    VentanaPrincipal v = new VentanaPrincipal(d, l);
                    vp.dispose();
                    v.setFocusable(true);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else {
                vp.validate();
                vp.setFocusable(true);
            }
        } else if (ae.getSource() == vp.getbGuardar()) {
            JFileChooser selector = new JFileChooser(); 
            int retrival = selector.showSaveDialog(null);
            if (retrival == JFileChooser.APPROVE_OPTION) {
                try {
                    FileOutputStream fos = new FileOutputStream(selector.getSelectedFile());
                    ObjectOutputStream salida = new ObjectOutputStream(fos);
                    salida.writeObject(vp.getDirector());
                    salida.writeObject(vp.getLaberinto());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            vp.validate();
            vp.setFocusable(true);

        } else if (ae.getSource() == vp.getbAbout()) {
            vp.getvA().setVisible(true);
        } else if (ae.getSource() == vp.getbSalir()) {
            vp.dispose();
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int result = -1;


        switch (e.getKeyCode()) {
          case KeyEvent.VK_DOWN: result = vp.getLaberinto().play('s');
          //vp.getLaberinto().pintar();
          break;
          case KeyEvent.VK_UP: result = vp.getLaberinto().play('w');
          //vp.getLaberinto().pintar();
          break;
          case KeyEvent.VK_LEFT: result = vp.getLaberinto().play('a');
          //vp.getLaberinto().pintar();
          break;
          case KeyEvent.VK_RIGHT: result = vp.getLaberinto().play('d');
          //vp.getLaberinto().pintar();
          break;
          default: //do nothing
        }
        vp.getPJuego().removeAll();
        vp.setPHabitacion(new JPanel());
        vp.pintarLab(vp.getPHabitacion());
        JPanel pEstadoJuego = new JPanel();
        pEstadoJuego.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
        switch (result) {
        case -2:
            pEstadoJuego.add(new JLabel("CONGRATS! YOU WIN."));
            break;
        case -3:
            pEstadoJuego.add(new JLabel("SORRY. YOU LOSE!"));
            break;
        default:
            if (vp.getLaberinto().getTipo().equalsIgnoreCase("Mario")) {
                pEstadoJuego.add(new JLabel("Mario Bros. Vidas: "
                                            + MarioHab.getVidas()));
                vp.getPJuego().add(vp.getPHabitacion(), BorderLayout.CENTER);
            } else if (vp.getLaberinto().getTipo().equalsIgnoreCase("Pokemon")) {
                pEstadoJuego.add(new JLabel("Pokemons: "
                                 + PokemonHab.getPokemonCont()));
                vp.getPJuego().add(vp.getPHabitacion(), BorderLayout.CENTER);
            }
        }
        vp.getPJuego().add(pEstadoJuego, BorderLayout.SOUTH);
        vp.validate();

    }
    @Override
    public void keyReleased(KeyEvent e) {
        // NADA

    }
    @Override
    public void keyTyped(KeyEvent e) {
        // NADA

    }
}

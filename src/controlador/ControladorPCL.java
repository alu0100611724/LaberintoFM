package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import modelo.builder.Director;
import modelo.builder.JuegoMarioLabBuilder;
import modelo.builder.JuegoPokemonLabBuilder;
import vista.VentanaPrincipal;

public class ControladorPCL implements ActionListener, ChangeListener {

    private VentanaPrincipal vp;

    public ControladorPCL (VentanaPrincipal vPrincipal) {
        vp = vPrincipal;
    }

    @Override
    public void stateChanged(ChangeEvent arg0) {

        if (arg0.getSource() == vp.getpCL().getsNumHabs()) {
            if (vp.getpCL().getsNumHabs().getValue() < 10) {

                vp.getpCL().getlNumHabs().setText("0" + String.valueOf(
                                        vp.getpCL().getsNumHabs().getValue()));
            } else {
                vp.getpCL().getlNumHabs().setText(String.valueOf(
                                        vp.getpCL().getsNumHabs().getValue()));
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vp.getpCL().getRbMario()) {
            vp.setBuilder(new JuegoMarioLabBuilder());
        } else if (e.getSource() == vp.getpCL().getRbPokemon()) {
            vp.setBuilder(new JuegoPokemonLabBuilder());
        } else if (e.getSource() == vp.getpCL().getbSiguiente()) {
            vp.getpCL().setVisible(false);
            vp.getpCH().setVisible(true);
            vp.setDirector(new Director(vp.getBuilder()));
            vp.getDirector().setNumHabs(vp.getpCL().getsNumHabs().getValue());
            vp.getpCC().setMaxSHabO(vp.getpCL().getsNumHabs().getValue());
            vp.getpCC().setMaxSHabD(vp.getpCL().getsNumHabs().getValue());
        } else if (e.getSource() == vp.getpCL().getbCancelar()) {
            vp.getpCL().dispose();
            vp.resetVentanas();
        }

    }

}

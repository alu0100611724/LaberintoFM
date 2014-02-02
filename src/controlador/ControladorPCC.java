package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import modelo.builder.Director;
import modelo.productos.Laberinto;
import vista.PanelConfigConexiones;
import vista.VentanaPrincipal;

public class ControladorPCC implements ActionListener, ChangeListener {

    private VentanaPrincipal vp;

    public ControladorPCC (VentanaPrincipal vPrincipal) {
        vp = vPrincipal;
    }

    @Override
    public void stateChanged(ChangeEvent arg0) {

        // Slider Habitacion Origen
        if (arg0.getSource() == vp.getpCC().getsHabO()) {

            if (vp.getpCC().getsHabO().getValue() < 10) {

                vp.getpCC().getlHabO().setText("0" + String.valueOf(
                                vp.getpCC().getsHabO().getValue()));
            } else {
                vp.getpCC().getlHabO().setText(String.valueOf(
                                vp.getpCC().getsHabO().getValue()));
            }

        // Slider Hab Destino
        } else if (arg0.getSource() == vp.getpCC().getsHabD()) {

            if (vp.getpCC().getsHabD().getValue() < 10) {

                vp.getpCC().getlHabD().setText("0" + String.valueOf(
                        vp.getpCC().getsHabD().getValue()));
            } else {
                vp.getpCC().getlHabD().setText(String.valueOf(
                        vp.getpCC().getsHabD().getValue()));
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Boton Otra conexion
        if (e.getSource() == vp.getpCC().getbOtra()) {
            vp.getpCC().dispose();
            vp.setpCC(new PanelConfigConexiones(vp));
            vp.getpCC().setMaxSHabO(vp.getDirector().getNumHabs());
            vp.getpCC().setMaxSHabD(vp.getDirector().getNumHabs());
            vp.getpCC().setVisible(true);
            //fijamos valores por defecto
            vp.getDirector().setPuertaOrigin(1);
            vp.getDirector().setPuertaDest(1);

            if (vp.getpCC().getoN().isEnabled()) {
                vp.getDirector().setPuertaOrigin(1);
            }
            if (vp.getpCC().getoS().isEnabled()) {
                vp.getDirector().setPuertaOrigin(2);
            }
            if (vp.getpCC().getoE().isEnabled()) {
                vp.getDirector().setPuertaOrigin(3);
            }
            if (vp.getpCC().getoO().isEnabled()) {
                vp.getDirector().setPuertaOrigin(4);
            }
            if (vp.getpCC().getdN().isEnabled()) {
                vp.getDirector().setPuertaDest(1);
            }
            if (vp.getpCC().getdS().isEnabled()) {
                vp.getDirector().setPuertaDest(2);
            }
            if (vp.getpCC().getdE().isEnabled()) {
                vp.getDirector().setPuertaDest(3);
            }
            if (vp.getpCC().getdO().isEnabled()) {
                vp.getDirector().setPuertaDest(4);
            }

            // creamos ultima habitacion
            vp.getDirector().crearConexion(
                    (vp.getpCC().getsHabO().getValue() - 1),
                    vp.getDirector().getPuertaOrigin(),
                    (vp.getpCC().getsHabD().getValue() - 1),
                    vp.getDirector().getPuertaDest());

        // Boton Fin
        } else if (e.getSource() == vp.getpCC().getbFin()) {

            //fijamos valores por defecto
            vp.getDirector().setPuertaOrigin(1);
            vp.getDirector().setPuertaDest(1);

            if (vp.getpCC().getoN().isEnabled()) {
                vp.getDirector().setPuertaOrigin(1);
            }
            if (vp.getpCC().getoS().isEnabled()) {
                vp.getDirector().setPuertaOrigin(2);
            }
            if (vp.getpCC().getoE().isEnabled()) {
                vp.getDirector().setPuertaOrigin(3);
            }
            if (vp.getpCC().getoO().isEnabled()) {
                vp.getDirector().setPuertaOrigin(4);
            }
            if (vp.getpCC().getdN().isEnabled()) {
                vp.getDirector().setPuertaDest(1);
            }
            if (vp.getpCC().getdS().isEnabled()) {
                vp.getDirector().setPuertaDest(2);
            }
            if (vp.getpCC().getdE().isEnabled()) {
                vp.getDirector().setPuertaDest(3);
            }
            if (vp.getpCC().getdO().isEnabled()) {
                vp.getDirector().setPuertaDest(4);
            }

            // creamos ultima habitacion
            vp.getDirector().crearConexion(
                    (vp.getpCC().getsHabO().getValue() - 1),
                    vp.getDirector().getPuertaOrigin(),
                    (vp.getpCC().getsHabD().getValue() - 1),
                    vp.getDirector().getPuertaDest());
            vp.getDirector().habActual(0);

            // Guardamos nuevo laberinto
            Director d = vp.getDirector();
            Laberinto l = vp.getDirector().getBuilder().getLab();
            vp.resetVentanas();
            vp.dispose();
            VentanaPrincipal v = new VentanaPrincipal(d, l);
            v.setFocusable(true);

        }
    }

}

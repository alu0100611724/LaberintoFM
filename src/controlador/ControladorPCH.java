package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import vista.PanelConfigHab;
import vista.VentanaPrincipal;

public class ControladorPCH implements ActionListener, ChangeListener {

    private VentanaPrincipal vp;

    public ControladorPCH (VentanaPrincipal vPrincipal) {
        vp = vPrincipal;
    }

    @Override
    public void stateChanged(ChangeEvent arg0) {

        // Slider Tam Habitacion
        if (arg0.getSource() == vp.getpCH().getsTam()) {

            if (vp.getpCH().getsTam().getValue() < 10) {

                vp.getpCH().getlTam().setText("0" + String.valueOf(
                        vp.getpCH().getsTam().getValue()));
            } else {
                vp.getpCH().getlTam().setText(String.valueOf(
                        vp.getpCH().getsTam().getValue()));
            }
            // Controlamos que no existan mas monstruos que vacios.
            vp.getpCH().getsMonstruos().setMaximum(
                    vp.getpCH().getsTam().getValue() - 2);

        // Slider Num Monstruos
        } else if (arg0.getSource() == vp.getpCH().getsMonstruos()) {

            if (vp.getpCH().getsMonstruos().getValue() < 10) {
                vp.getpCH().getlMonstruos().setText("0" + String.valueOf(
                        vp.getpCH().getsMonstruos().getValue()));
            } else {
                vp.getpCH().getlMonstruos().setText(String.valueOf(
                        vp.getpCH().getsMonstruos().getValue()));
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Boton siguiente
        if (e.getSource() == vp.getpCH().getbSiguiente()) {

            if (vp.getContHabs() < vp.getDirector().getNumHabs()) {
                vp.getDirector().crearHab(vp.getpCH().getsTam().getValue(),
                        vp.getpCH().getsMonstruos().getValue());
                vp.getpCH().dispose();
                vp.setContHabs(vp.getContHabs() + 1);
                vp.setpCH(new PanelConfigHab(vp));
                vp.getpCH().setTitle("Hab: " + vp.getContHabs());
                vp.getpCH().setVisible(true);
            } else {
                vp.getDirector().crearHab(vp.getpCH().getsTam().getValue(),
                        vp.getpCH().getsMonstruos().getValue());
                vp.getpCH().setVisible(false);
                vp.getpCC().setVisible(true);
            }

        // Boton Cancelar
        } else if (e.getSource() == vp.getpCH().getbCancelar()) {
            vp.getpCL().dispose();
            vp.resetVentanas();
        }
    }

}

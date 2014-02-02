package cliente;

import controlador.ControladorPCC;
import controlador.ControladorPCH;
import controlador.ControladorPCL;
import controlador.ControladorVP;
import vista.VentanaPrincipal;
import modelo.builder.Builder;
import modelo.builder.Director;
import modelo.builder.JuegoMarioLabBuilder;
import modelo.productos.Laberinto;

/**
 * Cliente con GUI.
 * @author Mauri
 *
 */
public class ClienteMVC {

    public static void main(String[] args) {

        // Modelo
        Builder builder = new JuegoMarioLabBuilder();
        Director director = new Director(builder);
        Laberinto laberinto = new Laberinto();
        try {
            laberinto = director.cargarPredeterminado();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Vista
        VentanaPrincipal vPrincipal = new VentanaPrincipal(director, laberinto);

        // Controladores
        ControladorVP cVP = new ControladorVP(vPrincipal);
        ControladorPCL cPCL = new ControladorPCL(vPrincipal);
        ControladorPCH cPCH = new ControladorPCH(vPrincipal);
        ControladorPCC cPCC = new ControladorPCC(vPrincipal);

        // Asignacion Controladores
        vPrincipal.setcVP(cVP);
        vPrincipal.getpCL().setcPCL(cPCL);
        vPrincipal.getpCH().setcPCH(cPCH);
        vPrincipal.getpCC().setcPCC(cPCC);

    }

}

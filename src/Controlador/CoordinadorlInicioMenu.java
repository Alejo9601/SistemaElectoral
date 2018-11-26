
package Controlador;

import Vista.Login;
import Vista.PrevisualizacionPadron;
import Vista.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Alejandro Juarez
 */
public class CoordinadorlInicioMenu implements ActionListener {

    private final Login ventanaLogin;
    private final Principal ventanaMenu;

    /**
     * Constructor de la clase
     */
    public CoordinadorlInicioMenu() {
        ventanaLogin = new Login();
        ventanaMenu = new Principal();
        ventanaLogin.setCoordinador(this); //Hago que la ventana sepa que este es su coordinador.
        ventanaMenu.setCoordinador(this); //
    }

    /**
     * Metodo para mostrar la ventana de inicio de sesion.
     *
     * @param condicion
     */
    public void mostrarVistaLogin(boolean condicion) {
        if(condicion == false) {
            ventanaLogin.dispose();
        }    
        if (condicion == true) {
            ventanaLogin.setVisible(true);
            ventanaLogin.setLocationRelativeTo(null);
        }
    }

    /**
     * Metodo para mostrar la ventana de menu principal.
     * @param condicion
     */
    public void mostrarVistaPrincipal(boolean condicion) {
        if(condicion == false) {
            ventanaMenu.dispose();
        }    
        if (condicion == true) {
            ventanaMenu.setVisible(true);
            ventanaMenu.setLocationRelativeTo(null);
        }
    }

    /**
     * Sobreescribe el actionPerformed de la interface ActionListener.
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {

            case "ACEPTAR":
                mostrarVistaPrincipal(true);
                mostrarVistaLogin(false);
                break;
            case "SALIR":
                System.exit(0);
                break;
            case "PADRONELECTORAL": 
                PrevisualizacionPadron padron = new PrevisualizacionPadron();
                padron.setVisible(true);
                padron.setLocationRelativeTo(null);
                break;
        }
    }

}

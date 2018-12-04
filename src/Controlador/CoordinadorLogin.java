/**
 *  Esta clase actua como mediadora o coordinadora entre las acciones que solicita
 *  el usuario a traves de la ventana y el modelo de solucion planteado.
 */
package Controlador;

import Modelo.Logica.GestorUsuario;
import Vista.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Alejandro Juarez
 */
public class CoordinadorLogin implements ActionListener {

    private final Login ventanaLogin;

    /**
     * Constructor de la clase.
     */
    public CoordinadorLogin() {
        ventanaLogin = new Login();
        ventanaLogin.setCoordinador(this); //Hago que la ventana sepa que este es su coordinador.
    }

    /**
     * Metodo para mostrar la ventana de inicio de sesion.
     *
     * @param condicion
     */
    public void mostrarVistaLogin(boolean condicion) {
        if (condicion == false) {//Si la condicion es false cierro la ventana.
            ventanaLogin.dispose();
        }
        if (condicion == true) {//Si la condicion es true muestro la ventana.
            ventanaLogin.setVisible(true);
            ventanaLogin.setLocationRelativeTo(null);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        switch (ae.getActionCommand()) {
            case "ACEPTAR":
                String usuario = ventanaLogin.getNombreUsuario();
                String contraseña = ventanaLogin.getContraseñaUsuario();
                
                //Si el usuario y la contraseña son distintas a un string vacio.
                if ((!usuario.equals("")) && (!contraseña.equals(""))) {
                    //Nuevo gestor de usuario para validar la sesion.
                    if (GestorUsuario.validarSesion(usuario, contraseña) == true) {
                        //Creo el coordinador del menu principal y lo muestro.
                        CoordinadorMenuPrincipal coordinador = new CoordinadorMenuPrincipal();
                        coordinador.mostrarVistaPrincipal(true);
                        mostrarVistaLogin(false); //Cierro la ventanaLogin 
                    } else {
                        ventanaLogin.mostrarMensajeAdvertencia("El nombre o contraseña ingresados no son correctos");
                    }
                } else if ((contraseña.equals("")) && (usuario.equals(""))) {
                    ventanaLogin.mostrarMensajeAdvertencia("El campo 'Usuario' y 'Contraseña' no pueden estar vacios");
                } else if (usuario.equals("")) {
                    ventanaLogin.mostrarMensajeAdvertencia("El campo 'Usuario' no puede estar vacio");
                } else {
                    ventanaLogin.mostrarMensajeAdvertencia("El campo 'Contraseña' no puede estar vacio");
                }
                break;
            case "SALIR":
                System.exit(0);
                break;
        }

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.Login;
import Vista.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Alejandro Juarez
 */
public class CoordinadorlInicioSistema implements ActionListener {

    private final Login ventanaLogin;
    private final Principal ventanaMenu;

    /**
     * Constructor de la clase
     */
    public CoordinadorlInicioSistema() {
        ventanaLogin = new Login();
        ventanaMenu = new Principal();        
         ventanaLogin.setCoordinador(this); //Hago que la ventana sepa que este es su coordinador.
         ventanaMenu.setCoordinador(this);//
    }

    /**
     * Metodo para mostrar la ventana de inicio de sesion.
     */
    public void iniciarVistaLogin() {
        ventanaLogin.setVisible(true);
        ventanaLogin.setLocationRelativeTo(null);
    }

    /**
     * Metodo para mostrar la ventana de menu principal.
     */
    public void iniciarVistaPrincipal() {
        ventanaMenu.setVisible(true);
        ventanaMenu.setLocationRelativeTo(null);
    }
    
    /**
     * Sobreescribe el actionPerformed de la interface ActionListener.
     * @param ae 
     */
    @Override
    public void actionPerformed(ActionEvent ae) {

        switch (ae.getActionCommand()) {

            case "ACEPTAR":
                iniciarVistaPrincipal();
                break;
            case "SALIR":
                System.exit(0);
                break;
        }

    }

}

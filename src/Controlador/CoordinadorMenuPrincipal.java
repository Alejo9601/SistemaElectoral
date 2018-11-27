package Controlador;

import Vista.MenuPrincipal;
import Vista.PrevisualizacionPadron;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Alejandro Juarez
 */
public class CoordinadorMenuPrincipal implements ActionListener {

    private static MenuPrincipal menu;
    private FileDialog dialogoArchivo;

    /**
     * Constructor de la clase.
     */
    public CoordinadorMenuPrincipal() {
        //Ventana de seleccion de archivo.
        dialogoArchivo = dialogoArchivo = new FileDialog(menu, "Seleccion de archivo", FileDialog.LOAD);
        //Ventana de menu principal.
        menu = new MenuPrincipal();
        menu.setCoordinador(this);
    }

    /**
     * Muestra la ventana de menu principal, o no, segun la condicion.
     *
     * @param condicion
     */
    public void mostrarVistaPrincipal(boolean condicion) {
        if (condicion == false) {
            menu.dispose();
        }
        if (condicion == true) {
            menu.setVisible(true);
            menu.setLocationRelativeTo(null);
        }
    }

    /**
     * Muestra la ventana de seleccion de archivo.
     *
     */
    private void mostrarVistaSeleccionArchivo() {
        dialogoArchivo.setVisible(true);
        dialogoArchivo.setLocationRelativeTo(null);
    }

    /**
     * Sobreescribe el metodo actionPerformed de ActionListener.
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {
            case "PADRONELECTORAL":
                PrevisualizacionPadron padron = new PrevisualizacionPadron();
                padron.setVisible(true);
                padron.setLocationRelativeTo(null);
                break;
            case "REGISTRARUSUARIO":
                break;
            case "IMPORTARELECTORES":
                mostrarVistaSeleccionArchivo();
                if (dialogoArchivo.getFile() != null) {
                    //Validar que se haya Seleccionado un Archivo
                    String directorio = dialogoArchivo.getDirectory();
                    String nombreArchivo = dialogoArchivo.getFile();
                    String rutatotal = directorio + nombreArchivo;
                } else {
                    menu.mostrarMensajeAdvertencia("No se selecciono ningun archivo");
                }
                break;
        }

    }

}

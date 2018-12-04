package Controlador;

import Vista.MenuPrincipal;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 *
 * @author Alejandro Juarez
 */
public class CoordinadorMenuPrincipal implements ActionListener {

    private static MenuPrincipal menu; //Ventana principal o Menu
    private FileDialog dialogoArchivo; //Ventana de seleccion de archivo.

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
     * Muestra la ventana de menu principal.
     *
     * @param condicion
     */
    public void mostrarVistaPrincipal(boolean condicion) {
        if (condicion == false) {//Si la condicion es falsa cierro el menu principal.
            menu.dispose();
        }
        if (condicion == true) {//Si la condicion es true muestro el menu principal.
            menu.setVisible(true);
            menu.setLocationRelativeTo(null);
        }
    }

    /**
     * Muestra la ventana de seleccion de archivo.
     *
     */
    private void mostrarVistaSeleccionArchivo() {
        dialogoArchivo.setFilenameFilter((File dir, String name) -> name.endsWith(".xls") || name.endsWith(".xlsx"));
        dialogoArchivo.setVisible(true);
        dialogoArchivo.setLocationRelativeTo(null);
    }

    /**
     * Sobreescribe el metodo actionPerformed de ActionListener, el metodo
     * utilizara objetos del sistema en dependencia del evento originado por el
     * usuario en la interfaz grafica.
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        CoordinadorElectores CE = new CoordinadorElectores();
        switch (ae.getActionCommand()) {
            case "PADRONELECTORAL":
                CE.mostrarVistaPadronElectoral(true);
                break;
            case "REGISTRARELECTOR":
                CE.mostrarVistaRegistroElector(menu);
                break;
            case "IMPORTARELECTORES":
                mostrarVistaSeleccionArchivo();
                if (dialogoArchivo.getFile() != null) {
                    //Validar que se haya Seleccionado un Archivo
                    String directorio = dialogoArchivo.getDirectory();
                    String nombreArchivo = dialogoArchivo.getFile();
                    String rutatotal = directorio + nombreArchivo;
                }
                break;
        }

    }

}

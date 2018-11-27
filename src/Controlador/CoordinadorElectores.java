package Controlador;

import Vista.PadronElectoral;
import Vista.RegistroElector;
import javax.swing.JFrame;

/**
 *
 * @author Alejandro Juarez
 */
public class CoordinadorElectores {

    RegistroElector dialogoRegistro;
    PadronElectoral padronElectoral;

    /**
     * Constructor.
     */
    public CoordinadorElectores() {

    }

    /**
     * Mostrara el dialogo registro elector.
     *
     * @param ventanaPadre
     */
    public void mostrarVistaRegistroElector(JFrame ventanaPadre) {
        dialogoRegistro = new RegistroElector(ventanaPadre, true);
        dialogoRegistro.setVisible(true);
    }

}

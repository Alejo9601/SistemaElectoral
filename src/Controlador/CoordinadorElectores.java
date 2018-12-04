package Controlador;

import Modelo.Logica.GestorConfiguraciones;
import Modelo.Logica.GestorElectores;
import Vista.PadronElectoral;
import Vista.RegistroElector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alejandro Juarez
 */
public class CoordinadorElectores implements ActionListener {

    RegistroElector DR;
    PadronElectoral PE;

    /**
     * Constructor de la clase.
     */
    public CoordinadorElectores() {
        PE = new PadronElectoral();
    }

    /**
     * Mostrara el JDialog DR.
     *
     * @param ventanaPadre
     */
    public void mostrarVistaRegistroElector(JFrame ventanaPadre) {
        DR = new RegistroElector(ventanaPadre, true);
        DR.setControlador(this); //Especifico al JDialog que su controlador es esta clase
        GestorConfiguraciones.consultarCarreras().forEach((carrera) -> {//Recorro la lista de carreras y obtengo su nombre [0] y codigo [1]
            DR.agregarNuevaCarrera(carrera[0], carrera[1]);//Agrego cada una de las carreras y sus codigos al formulario
        });
        DR.setVisible(true);//Hago visibel el JDialog
    }

    /**
     * Mostrara el JFrame PE.
     *
     * @param condicion
     */
    public void mostrarVistaPadronElectoral(boolean condicion) {
        if (condicion == false) {//Si la condicion es false la vista.
            PE.dispose();
        }
        if (condicion == true) {//Si la condicion es true agrego los modelos a la vista y la hago visible 
            agregarDatosPadron();
            PE.setVisible(true);
            PE.setLocationRelativeTo(null);
        }
    }

    /**
     * Metodo para agregar los modelos de tabla al padron electoral PE.
     */
    private void agregarDatosPadron() {
        List<DefaultTableModel> modelos = GestorElectores.consultarPadronEstudiantes(); //Lista de modelos.
        PE.setModeloTablaAlumnos(modelos.get(0)); //Agrego el modelo a la tabla alumnos
    }

    /**
     * Sobreescribe el metodo actionPerformed de la interfaz ActionListener.
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {
            case "REGISTRARELECTOR":
                if (DR.camposVacios() != true) {//Si los campos del form no estan vacios registro
                    if (GestorElectores.registrarElector(DR.getInfoElector()) == true) {
                        DR.mostrarMensajeConfirmacion("El registro se efectuo correctamente");
                        DR.dispose();
                    } else {
                        DR.mostrarMensajeAdvertencia("El registro no se pudo efectuar");
                    }
                } else {
                    DR.mostrarMensajeAdvertencia("Los campos del formulario no debe estar vacios");
                }
                break;
        }

    }

}

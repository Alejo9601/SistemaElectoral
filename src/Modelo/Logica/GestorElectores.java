package Modelo.Logica;

import Modelo.Persistencia.BD.ElectoresDB;
import Modelo.Persistencia.POJO.Carrera;
import Modelo.Persistencia.POJO.Estudiante;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alejandro Juarez
 */
public class GestorElectores {

    /**
     * Metodo que gestionara el proceso de registro de un elector.
     *
     * @param pElector
     * @return
     */
    public static boolean registrarElector(Map<String, String> pElector) {
        ElectoresDB DB = new ElectoresDB();

        switch (pElector.get("CLAUSTRO")) {
            case "ESTUDIANTE":
                Estudiante estudiante = new Estudiante(Long.parseLong(pElector.get("NRODOC")),
                        new Carrera(Integer.parseInt(pElector.get("CODIGOCARRERA")), pElector.get("NOMBRECARRERA")),
                        pElector.get("NOMBRE"),
                        pElector.get("APELLIDO"),
                        pElector.get("LEGAJO"),
                        Integer.parseInt(pElector.get("ULTREINSCRIPCION")),
                        Integer.parseInt(pElector.get("CANTMATERIAS")),
                        pElector.get("LOCALIDAD"));
                return DB.altaEstudiante(estudiante) == true;
            case "DOCENTE":
                break;
            case "NO DOCENTE":
                break;

        }

        return false;
    }

    /**
     * Metodo para extraer los datos de los electores que se encuentran en un
     * archivo.
     *
     * @param archivo
     * @return
     */
    public boolean leerArchivoEstudiantes(File archivo) {

        boolean bandera = false;
        return bandera;

    }

    /**
     * Metodo que consultara el padron de estudiantes.
     *
     * @return
     */
    public static List<DefaultTableModel> consultarPadronEstudiantes() {

        ElectoresDB DB = new ElectoresDB();

        //Modelos de tabla para cada uno de los claustros.
        DefaultTableModel docentes;
        DefaultTableModel noDocentes;

        //Listas que almacenaran la listas por cada claustro consultado de la base de datos.
        List<Estudiante> LE = DB.consultarEstudiantes();

        //Creo la lista de modelos
        List<DefaultTableModel> LM = new ArrayList<>();

        if (!LE.isEmpty()) {
            DefaultTableModel estudiantes = new DefaultTableModel(null, new String[]{"NOMBRES", "APELLIDO", "NRO. DOC", "LEGAJO", "LOCALIDAD"});
            LE.forEach((x) -> {
                estudiantes.addRow(new Object[]{x.getNombre(), x.getApellido(), x.getDni(), x.getLegajo(), x.getLocalidad()});
            });
            LM.add(estudiantes);
        }

        //Falta implementar para docentes
        //Falta implementar para noDocentes
        return LM;

    }

}

package Modelo.Logica;

import Modelo.Persistencia.BD.ConfiguracionesBD;
import Modelo.Persistencia.POJO.Carrera;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandro Juarez
 */
public class GestorConfiguraciones {

    /**
     * Metodo para consultar las carreras.
     *
     * @return
     */
    public static List<String[]> consultarCarreras() {
        //Objeto que reliza la consulta
        ConfiguracionesBD config = new ConfiguracionesBD();
        //Lista de carreras
        List<Carrera> ListaCarreras = config.consultarCarreras();
        /*
          Objeto que se retornara, es una lista de String que contendra el
          nombre de la carrera[0] y su codigo [1]
         */
        List<String[]> carreras = new ArrayList<>();
        //Recorro la lista de carreras y agrego su nombre y codigo a la otra lista
        ListaCarreras.forEach((Carrera x) -> {
            carreras.add(new String[]{x.getNombrecarrera(), Integer.toString(x.getCodigocarrera())});
        });
        return carreras;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Persistencia.BD;

import Modelo.Persistencia.POJO.Carrera;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Alejandro Juarez
 */
public class ConfiguracionesBD {

    /**
     * Metodo para dar de alta una carrera.
     *
     * @param codigoCarrera
     * @param nombreCarrera
     * @return
     */
    public boolean altaCarrera(int codigoCarrera, String nombreCarrera) {
        Session sesion = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Carrera carrera = new Carrera(codigoCarrera, nombreCarrera);
        boolean bandera = true;
        try {
            tx = sesion.beginTransaction();
            sesion.save(carrera);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            bandera = false;
        } finally {
            sesion.close();
        }
        return bandera;
    }

    /**
     * Metodo para consultar las carreras disponibles en la base de datos.
     *
     * @return Devuelve un List de carreras
     */
    public List<Carrera> consultarCarreras() {
        Session sesion = NewHibernateUtil.getSessionFactory().openSession();
        List<Carrera> listaCarreras = null;
        try {
            SQLQuery consulta = sesion.createSQLQuery("SELECT * FROM carrera");
            consulta.addEntity(Carrera.class);
            listaCarreras = consulta.list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo consultar las carreras..." + e.getMessage());
        }
        return listaCarreras;
    }

}

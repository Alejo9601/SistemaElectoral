package Modelo.Persistencia.BD;

import Modelo.Persistencia.POJO.Estudiante;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Alejandro Juarez
 */
public class ElectoresDB {

    /**
     * Metodo para dar de alta un estudiante.
     *
     * @param est
     * @return
     */
    public boolean altaEstudiante(Estudiante est) {
        Session sesion = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Estudiante estudiante = est;
        boolean bandera = true;
        try {
            tx = sesion.beginTransaction();
            sesion.save(estudiante);
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
     * Metodo para dar de alta un docente.
     *
     * @return
     */
    public boolean altaDocente() {
        Session sesion = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
//        Estudiante estudiante = est;
        boolean bandera = true;
        try {
            tx = sesion.beginTransaction();
//            sesion.save(estudiante);
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
     * Metodo para consultar todos los estudiantes registrados.
     *
     * @return
     */
    public List<Estudiante> consultarEstudiantes() {
        Session sesion = NewHibernateUtil.getSessionFactory().openSession();
        List<Estudiante> estudiantes = null;

        try {
            SQLQuery consulta = sesion.createSQLQuery("SELECT * FROM estudiante ORDER BY estudiante.nombre");
            consulta.addEntity(Estudiante.class);
            estudiantes = consulta.list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo consultar los estudiantes..." + e.getMessage());
        }

        return estudiantes;
    }

}

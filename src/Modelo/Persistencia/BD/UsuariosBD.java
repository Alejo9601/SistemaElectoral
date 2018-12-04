package Modelo.Persistencia.BD;

import Modelo.Persistencia.POJO.Usuario;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateError;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Marco Tornese
 */
public class UsuariosBD {

    /**
     * Metodo para dar el alta de un nuevo usuario.
     *
     * @param nombre
     * @param password
     * @return
     */
    public boolean alta(String nombre, String password) {
        Session sesion = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Usuario usuario = new Usuario(nombre, password);
        Boolean bandera = true;
        try {
            tx = sesion.beginTransaction();
            sesion.save(usuario);
            tx.commit();
        } catch (HibernateError e) {
            if (tx != null) {
                tx.rollback();
            }
            bandera = false;
            JOptionPane.showMessageDialog(null, "Error", "Dando de alta al usuario", JOptionPane.ERROR_MESSAGE);
        } finally {
            sesion.close();
        }
        return bandera;
    }

    /**
     * Metodo para dar de baja un usuario.
     */
    public void baja() {

        try {

        } catch (Exception e) {
        }

    }

    /**
     * Metodo para consultar un usuario.
     *
     * @param nombre
     * @param password
     * @return
     */
    public Usuario consulta(String nombre, String password) {
        Session sesion = NewHibernateUtil.getSessionFactory().openSession();
        Usuario usuario = null;
        try {
            SQLQuery q = sesion.createSQLQuery("SELECT * FROM usuario WHERE nombre ='" + nombre + "' AND password = '" + password + "'");
            q.addEntity(Usuario.class);
            usuario = (Usuario) q.uniqueResult();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la consulta" + e.getMessage());
        } finally {
            sesion.close();
        }
        return usuario;
    }

    /**
     * Metodo para consultar todos los usuarios registrados.
     *
     * @return
     */
    public List<Usuario> consultarTodos() {
        Session sesion = NewHibernateUtil.getSessionFactory().openSession();
        List<Usuario> listaUsuario = null;
        try {
            SQLQuery q = sesion.createSQLQuery("SELECT * FROM usuario");
            q.addEntity(Usuario.class);
            listaUsuario = q.list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error 00001" + e.getMessage());
        } finally {
            sesion.close();
        }
        return listaUsuario;
    }

    /**
     * Metodo para dar de alta un movimiento en la base de datos.
     */
    public void altaMovimiento() {

        try {

        } catch (Exception e) {
        }
    }

}

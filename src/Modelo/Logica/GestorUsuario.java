
package Modelo.Logica;

import Modelo.Persistencia.BD.UsuariosBD;
import java.awt.List;

/**
 *
 * @author Alejandro Juarez
 */
public class GestorUsuario {

    /**
     * Metodo que validara la sesion del usuario.
     *
     * @param nombre
     * @param Contraseña
     * @return
     */
    public static boolean validarSesion(String nombre, String Contraseña) {
        UsuariosBD BD = new UsuariosBD();
        return BD.consulta(nombre, Contraseña) != null;
    }

    /**
     * Metodo para registrar un usuario en la base de datos.
     *
     * @param nombre
     * @param contraseña
     */
    public void registrarUsuario(String nombre, String contraseña) {

    }

    /**
     * Metodo para encriptar la contraseña del usuario cuando este se registre o
     * cambie la misma.
     *
     * @return
     */
    private String encriptarContraseña(String contraseña) {
        return new String();
    }

    /**
     * Metodo para consultar los usuarios de la base de datos.
     *
     */
    public void consultarUsuarios() {

    }

    /**
     * Metodo para registrar el movimiento de un usuario.
     *
     * @param movimiento
     * @param nombreUsuario
     */
    public void registrarMovimiento(String movimiento, String nombreUsuario) {

    }

    /**
     * Metodo para consultar el log de movimientos del sistema.
     */
    public List consultarMovimientosDeHoy() {
        return new List();
    }

    /**
     * Metodo para consultar todos los movimientos realizados del sistema.
     */
    public List consultarTodosLosMovimientos() {
        return new List();
    }

    /**
     * Metodo para consultar los movimientos de un usuario determinado.
     *
     * @param nombre
     */
    public List consultarMovimientosDeUsuario(String nombre) {
        return new List();
    }

}

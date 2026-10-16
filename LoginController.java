package controlador;

import modelo.Login;
import modelo.Tecnico;

/**
 * Controlador del Login (patron MVC).
 * Sirve como puente entre la vista InterfazLogin y el modelo Login.
 */
public class LoginController {

    private final Login login = new Login();

    /** Tecnico que quedo autenticado en la sesion actual. */
    private static Tecnico tecnicoActivo;

    /**
     * Intenta autenticar al usuario. Si es valido lo guarda como sesion activa.
     *
     * @return true si las credenciales son correctas.
     */
    public boolean autenticar(String usuario, String password) {
        Tecnico t = login.validar(usuario, password);
        if (t != null) {
            tecnicoActivo = t;
            return true;
        }
        return false;
    }

    /** Tecnico logueado en la sesion actual (null si nadie hizo login). */
    public static Tecnico getTecnicoActivo() {
        return tecnicoActivo;
    }

    /** Cierra la sesion (usado al presionar Salir). */
    public static void cerrarSesion() {
        tecnicoActivo = null;
    }
}

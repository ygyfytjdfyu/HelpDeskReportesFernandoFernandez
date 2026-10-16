package modelo;

/**
 * Entidad Tecnico (POJO del modelo).
 * Representa al personal que atiende y resuelve las incidencias.
 *
 * Se corresponde con la tabla `tecnico` de la base de datos helpdesk3.
 */
public class Tecnico {

    private int id;
    private String ci;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String usuario;
    private String password;
    private int idEspecialidad;
    private boolean estado;

    /** Nombre de la especialidad; no es columna de `tecnico`, viene del JOIN. */
    private String nombreEspecialidad;

    public Tecnico() {
        this.estado = true;
    }

    public Tecnico(int id, String ci, String nombre, String apellido,
                   String telefono, String email, String usuario,
                   String password, int idEspecialidad, boolean estado) {
        this.id = id;
        this.ci = ci;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.usuario = usuario;
        this.password = password;
        this.idEspecialidad = idEspecialidad;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getNombreEspecialidad() {
        return nombreEspecialidad;
    }

    public void setNombreEspecialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }

    /** Nombre completo, util para mostrar en tablas y combos. */
    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    @Override
    public String toString() {
        return getNombreCompleto();
    }
}

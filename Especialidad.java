package modelo;

/**
 * Entidad Especialidad (POJO del modelo).
 * Area de conocimiento asignada a un tecnico.
 *
 * Se corresponde con la tabla `especialidad` de la base de datos helpdesk3.
 */
public class Especialidad {

    private int id;
    private String nombre;
    private String descripcion;

    public Especialidad() {
    }

    public Especialidad(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Lo que se muestra dentro del JComboBox de especialidades.
     */
    @Override
    public String toString() {
        return nombre;
    }
}

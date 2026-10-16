
package modelo;


public class Usuario {
    private int idUsuario;
    private String nombres;
    private String apellidos;
    private String correo;
    private long telefono;
    private String cargo;
    private String area;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombres, String apellidos, String correo, long telefono, String cargo, String area) {
        this.idUsuario = idUsuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.cargo = cargo;
        this.area = area;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    
}

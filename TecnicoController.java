package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.ConexionMySQL;
import modelo.Especialidad;
import modelo.Tecnico;

/**
 * Controlador de Tecnicos (patron MVC).
 * Contiene las operaciones CRUD contra la tabla `tecnico`.
 *
 * Todas las consultas usan PreparedStatement para evitar inyeccion SQL.
 */
public class TecnicoController {

    private final ConexionMySQL conexion = new ConexionMySQL();

    // -----------------------------------------------------------------
    // LISTAR
    // -----------------------------------------------------------------

    /**
     * Devuelve todos los tecnicos con el nombre de su especialidad.
     *
     * @param filtro texto a buscar en nombre, apellido o CI.
     *               Si es null o vacio devuelve todos.
     */
    public List<Tecnico> listar(String filtro) {
        List<Tecnico> lista = new ArrayList<>();

        String sql = "SELECT t.id_tecnico, t.ci, t.nombre, t.apellido, t.telefono, "
                   + "       t.email, t.usuario, t.password, "
                   + "       IFNULL(t.id_especialidad, 0) AS id_especialidad, "
                   + "       IFNULL(e.nombre, '') AS especialidad, t.estado "
                   + "FROM tecnico t "
                   + "LEFT JOIN especialidad e ON e.id_especialidad = t.id_especialidad ";

        boolean hayFiltro = filtro != null && !filtro.trim().isEmpty();
        if (hayFiltro) {
            sql += "WHERE t.nombre LIKE ? OR t.apellido LIKE ? OR t.ci LIKE ? ";
        }
        sql += "ORDER BY t.apellido, t.nombre";

        try (Connection con = conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            if (hayFiltro) {
                String patron = "%" + filtro.trim() + "%";
                ps.setString(1, patron);
                ps.setString(2, patron);
                ps.setString(3, patron);
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(mapear(rs));
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al listar tecnicos: " + e.getMessage());
        }
        return lista;
    }

    /** Construye un Tecnico a partir de la fila actual del ResultSet. */
    private Tecnico mapear(ResultSet rs) throws SQLException {
        Tecnico t = new Tecnico();
        t.setId(rs.getInt("id_tecnico"));
        t.setCi(rs.getString("ci"));
        t.setNombre(rs.getString("nombre"));
        t.setApellido(rs.getString("apellido"));
        t.setTelefono(rs.getString("telefono"));
        t.setEmail(rs.getString("email"));
        t.setUsuario(rs.getString("usuario"));
        t.setPassword(rs.getString("password"));
        t.setIdEspecialidad(rs.getInt("id_especialidad"));
        t.setNombreEspecialidad(rs.getString("especialidad"));
        t.setEstado(rs.getBoolean("estado"));
        return t;
    }

    // -----------------------------------------------------------------
    // INSERTAR
    // -----------------------------------------------------------------

    /**
     * Registra un tecnico nuevo.
     *
     * @return true si se inserto correctamente.
     */
    public boolean insertar(Tecnico t) {
        String sql = "INSERT INTO tecnico "
                   + "(ci, nombre, apellido, telefono, email, usuario, password, id_especialidad, estado) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            cargarParametros(ps, t);
            ps.executeUpdate();

            // Recuperamos el id autogenerado y lo dejamos en el objeto
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    t.setId(rs.getInt(1));
                }
            }
            return true;

        } catch (SQLException e) {
            System.out.println("Error al insertar tecnico: " + e.getMessage());
            return false;
        }
    }

    // -----------------------------------------------------------------
    // ACTUALIZAR
    // -----------------------------------------------------------------

    /**
     * Guarda los cambios de un tecnico existente (identificado por su id).
     *
     * @return true si se actualizo alguna fila.
     */
    public boolean actualizar(Tecnico t) {
        String sql = "UPDATE tecnico SET "
                   + "ci = ?, nombre = ?, apellido = ?, telefono = ?, email = ?, "
                   + "usuario = ?, password = ?, id_especialidad = ?, estado = ? "
                   + "WHERE id_tecnico = ?";

        try (Connection con = conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            cargarParametros(ps, t);
            ps.setInt(10, t.getId());
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar tecnico: " + e.getMessage());
            return false;
        }
    }

    /** Carga los 9 parametros comunes a INSERT y UPDATE (posiciones 1..9). */
    private void cargarParametros(PreparedStatement ps, Tecnico t) throws SQLException {
        ps.setString(1, t.getCi());
        ps.setString(2, t.getNombre());
        ps.setString(3, t.getApellido());
        ps.setString(4, t.getTelefono());
        ps.setString(5, t.getEmail());
        ps.setString(6, t.getUsuario());
        ps.setString(7, t.getPassword());

        // id_especialidad admite NULL cuando no se eligio ninguna
        if (t.getIdEspecialidad() > 0) {
            ps.setInt(8, t.getIdEspecialidad());
        } else {
            ps.setNull(8, java.sql.Types.INTEGER);
        }
        ps.setBoolean(9, t.isEstado());
    }

    // -----------------------------------------------------------------
    // ELIMINAR
    // -----------------------------------------------------------------

    /**
     * Elimina un tecnico por su id.
     *
     * Puede fallar si el tecnico ya tiene incidencias asignadas
     * (restriccion de llave foranea).
     *
     * @return true si se elimino alguna fila.
     */
    public boolean eliminar(int idTecnico) {
        String sql = "DELETE FROM tecnico WHERE id_tecnico = ?";

        try (Connection con = conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idTecnico);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar tecnico: " + e.getMessage());
            return false;
        }
    }

    // -----------------------------------------------------------------
    // VALIDACIONES DE UNICIDAD
    // -----------------------------------------------------------------

    /**
     * Comprueba si un valor ya esta usado por OTRO tecnico.
     *
     * @param columna    "ci" o "usuario"
     * @param valor      valor a comprobar
     * @param idExcluir  id del tecnico que se esta editando (0 al registrar)
     */
    public boolean existe(String columna, String valor, int idExcluir) {
        // La columna no puede ir como parametro, por eso se valida contra
        // una lista blanca antes de concatenarla.
        if (!columna.equals("ci") && !columna.equals("usuario")) {
            throw new IllegalArgumentException("Columna no permitida: " + columna);
        }

        String sql = "SELECT 1 FROM tecnico WHERE " + columna + " = ? AND id_tecnico <> ?";

        try (Connection con = conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, valor);
            ps.setInt(2, idExcluir);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }

        } catch (SQLException e) {
            System.out.println("Error al verificar duplicados: " + e.getMessage());
            return false;
        }
    }

    // -----------------------------------------------------------------
    // APOYO : especialidades para el JComboBox
    // -----------------------------------------------------------------

    /** Lista las especialidades disponibles, para llenar el combo del formulario. */
    public List<Especialidad> listarEspecialidades() {
        List<Especialidad> lista = new ArrayList<>();
        String sql = "SELECT id_especialidad, nombre, descripcion "
                   + "FROM especialidad ORDER BY nombre";

        try (Connection con = conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new Especialidad(
                        rs.getInt("id_especialidad"),
                        rs.getString("nombre"),
                        rs.getString("descripcion")));
            }

        } catch (SQLException e) {
            System.out.println("Error al listar especialidades: " + e.getMessage());
        }
        return lista;
    }
}

package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDao {

    private ConexionMySQL conexion = new ConexionMySQL();

    // ---------- OBTENER PRÓXIMO ID LIBRE (para vista previa y para registrar) ----------
    public int obtenerSiguienteId() {
        String sql =
            "SELECT MIN(t1.id_usuario + 1) AS siguiente " +
            "FROM usuario t1 " +
            "LEFT JOIN usuario t2 ON t1.id_usuario + 1 = t2.id_usuario " +
            "WHERE t2.id_usuario IS NULL";

        try (Connection con = conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next() && rs.getObject("siguiente") != null) {
                return rs.getInt("siguiente");
            }

        } catch (SQLException ex) {
            System.out.println("Error al calcular siguiente ID: " + ex.getMessage());
        }
        return 1; // si la tabla está vacía o hay error, empieza en 1
    }

    // ---------- REGISTRAR (reutiliza IDs libres) ----------
    public boolean registrar(Usuario usuario) {
        int siguienteId = obtenerSiguienteId();

        String sqlInsertar = "INSERT INTO usuario (id_usuario, nombres, apellidos, correo, telefono, cargo, area) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sqlInsertar)) {

            ps.setInt(1, siguienteId);
            ps.setString(2, usuario.getNombres());
            ps.setString(3, usuario.getApellidos());
            ps.setString(4, usuario.getCorreo());
            ps.setLong(5, usuario.getTelefono());
            ps.setString(6, usuario.getCargo());
            ps.setString(7, usuario.getArea());
            ps.executeUpdate();

            usuario.setIdUsuario(siguienteId);
            return true;

        } catch (SQLException ex) {
            System.out.println("Error al registrar usuario: " + ex.getMessage());
            return false;
        }
    }

    // ---------- MODIFICAR ----------
    public boolean modificar(Usuario usuario) {
        String sql = "UPDATE usuario SET nombres=?, apellidos=?, correo=?, telefono=?, cargo=?, area=? WHERE id_usuario=?";

        try (Connection con = conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, usuario.getNombres());
            ps.setString(2, usuario.getApellidos());
            ps.setString(3, usuario.getCorreo());
            ps.setLong(4, usuario.getTelefono());
            ps.setString(5, usuario.getCargo());
            ps.setString(6, usuario.getArea());
            ps.setInt(7, usuario.getIdUsuario());

            return ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.out.println("Error al modificar usuario: " + ex.getMessage());
            return false;
        }
    }

    // ---------- ELIMINAR ----------
    public boolean eliminar(int idUsuario) {
        String sql = "DELETE FROM usuario WHERE id_usuario=?";

        try (Connection con = conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idUsuario);
            return ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.out.println("Error al eliminar usuario: " + ex.getMessage());
            return false;
        }
    }

    // ---------- LISTAR ----------
    public ArrayList<Usuario> listar() {
        ArrayList<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuario";

        try (Connection con = conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(mapearUsuario(rs));
            }

        } catch (SQLException ex) {
            System.out.println("Error al listar usuarios: " + ex.getMessage());
        }
        return lista;
    }

    // ---------- BUSCAR ----------
    public ArrayList<Usuario> buscar(String texto) {
        ArrayList<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuario WHERE nombres LIKE ? OR apellidos LIKE ? OR correo LIKE ?";

        try (Connection con = conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            String like = "%" + texto + "%";
            ps.setString(1, like);
            ps.setString(2, like);
            ps.setString(3, like);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(mapearUsuario(rs));
                }
            }

        } catch (SQLException ex) {
            System.out.println("Error al buscar usuarios: " + ex.getMessage());
        }
        return lista;
    }

    // ---------- MÉTODO AUXILIAR ----------
    private Usuario mapearUsuario(ResultSet rs) throws SQLException {
        return new Usuario(
            rs.getInt("id_usuario"),
            rs.getString("nombres"),
            rs.getString("apellidos"),
            rs.getString("correo"),
            rs.getLong("telefono"),
            rs.getString("cargo"),
            rs.getString("area")
        );
    }
}
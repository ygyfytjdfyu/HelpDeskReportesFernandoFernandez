package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
    private final ConexionMySQL conexion = new ConexionMySQL();

    public Tecnico validar(String usuario, String password) {
        String sql = "SELECT t.id_tecnico, t.nombres, t.apellidos, t.telefono, "
                   + "       t.correo, l.usuario, l.password, "
                   + "       IFNULL(t.especialidad_id, 0) AS especialidad_id, "
                   + "       IFNULL(e.nombre, '') AS especialidad "
                   + "FROM login l "
                   + "JOIN tecnico t ON l.tecnico_id = t.id_tecnico "
                   + "LEFT JOIN especialidad e ON e.id_especialidad = t.especialidad_id "
                   + "WHERE l.usuario = ? AND l.password = ?";

        try (Connection con = conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, usuario);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Tecnico t = new Tecnico();
                    t.setId(rs.getInt("id_tecnico"));
                    t.setNombre(rs.getString("nombres"));
                    t.setApellido(rs.getString("apellidos"));
                    t.setTelefono(rs.getString("telefono"));
                    t.setEmail(rs.getString("correo"));
                    t.setUsuario(rs.getString("usuario"));
                    t.setPassword(rs.getString("password"));
                    t.setIdEspecialidad(rs.getInt("especialidad_id"));
                    t.setNombreEspecialidad(rs.getString("especialidad"));
                    t.setEstado(true);
                    return t;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error en Login.validar(): " + e.getMessage());
        }
        return null;
    }
}
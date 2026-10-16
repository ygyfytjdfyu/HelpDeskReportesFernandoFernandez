package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReporteDao {

    ConexionMySQL cn = new ConexionMySQL();

    // REPORTE DETALLADO DE INCIDENCIAS
    public List<String[]> reporteIncidencias(String estado, String categoria) {
        List<String[]> lista = new ArrayList<>();
        String sql =
            "SELECT " +
            "i.ticket, " +
            "i.fecha, " +
            "i.hora, " +
            "i.titulo, " +
            "i.prioridad, " +
            "CONCAT(u.nombres,' ',u.apellidos) AS usuario, " +
            "COALESCE(CONCAT(t.nombres,' ',t.apellidos),'Sin asignar') AS tecnico, " +
            "c.nombre AS categoria, " +
            "e.nombre AS estado " +
            "FROM incidencia i " +
            "INNER JOIN usuario u " +
            "ON i.usuario_id = u.id_usuario " +
            "LEFT JOIN tecnico t " +
            "ON i.tecnico_id = t.id_tecnico " +
            "INNER JOIN categoria c " +
            "ON i.categoria_id = c.id_categoria " +
            "INNER JOIN estado e " +
            "ON i.estado_id = e.id_estado " +
            "WHERE (? = 'Todos' OR e.nombre = ?) " +
            "AND (? = 'Todas' OR c.nombre = ?) " +
            "ORDER BY i.fecha DESC, i.hora DESC";
        try {
            Connection conn = cn.getConexion();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, estado);
            pst.setString(2, estado);
            pst.setString(3, categoria);
            pst.setString(4, categoria);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String[] fila = new String[9];
                fila[0] = rs.getString("ticket");
                fila[1] = rs.getString("fecha");
                fila[2] = rs.getString("hora");
                fila[3] = rs.getString("titulo");
                fila[4] = rs.getString("prioridad");
                fila[5] = rs.getString("usuario");
                fila[6] = rs.getString("tecnico");
                fila[7] = rs.getString("categoria");
                fila[8] = rs.getString("estado");
                lista.add(fila);
            }
            rs.close();
            pst.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error en reporteIncidencias: " + e.getMessage());
        }
        return lista;
    }

    // REPORTE POR TÉCNICO
    public List<String[]> reportePorTecnico() {
        List<String[]> lista = new ArrayList<>();
        String sql =
            "SELECT " +
            "CONCAT(t.nombres,' ',t.apellidos) AS tecnico, " +
            "COUNT(i.id_incidencia) AS total " +
            "FROM tecnico t " +
            "LEFT JOIN incidencia i " +
            "ON t.id_tecnico = i.tecnico_id " +
            "GROUP BY t.id_tecnico, t.nombres, t.apellidos " +
            "ORDER BY total DESC";
        try {
            Connection conn = cn.getConexion();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String[] fila = new String[2];
                fila[0] = rs.getString("tecnico");
                fila[1] = rs.getString("total");
                lista.add(fila);
            }
            rs.close();
            pst.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error en reportePorTecnico: " + e.getMessage());
        }
        return lista;
    }

    // REPORTE POR CATEGORÍA
    public List<String[]> reportePorCategoria() {
        List<String[]> lista = new ArrayList<>();
        String sql =
            "SELECT " +
            "c.nombre AS categoria, " +
            "COUNT(i.id_incidencia) AS total " +
            "FROM categoria c " +
            "LEFT JOIN incidencia i " +
            "ON c.id_categoria = i.categoria_id " +
            "GROUP BY c.id_categoria, c.nombre " +
            "ORDER BY total DESC";
        try {
            Connection conn = cn.getConexion();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String[] fila = new String[2];
                fila[0] = rs.getString("categoria");
                fila[1] = rs.getString("total");
                lista.add(fila);
            }
            rs.close();
            pst.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error en reportePorCategoria: " + e.getMessage());
        }
        return lista;
    }
}

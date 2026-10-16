package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {

    private String bd = "helpdesk3";
    private String usuario = "root";
    private String password = "";
    private String url = "jdbc:mysql://localhost:3306/" + bd;
    Connection con = null;

    public Connection getConexion() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexión exitosa.");

        } catch (ClassNotFoundException e) {
            System.out.println("No se encontró el Driver MySQL.");

        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos.");
            System.out.println(e.getMessage());
        }
        return con;
    }
}
